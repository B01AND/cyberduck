package ch.cyberduck.core.onedrive.features;

/*
 * Copyright (c) 2002-2018 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.Filter;
import ch.cyberduck.core.ListProgressListener;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Search;
import ch.cyberduck.core.onedrive.GraphSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.nuxeo.onedrive.client.Files;
import org.nuxeo.onedrive.client.OneDriveRuntimeException;
import org.nuxeo.onedrive.client.types.DriveItem;

import java.util.EnumSet;
import java.util.Iterator;

public class GraphSearchFeature implements Search {
    private static final Logger log = Logger.getLogger(GraphSearchFeature.class);

    private final GraphSession session;
    private final GraphAttributesFinderFeature attributes;

    public GraphSearchFeature(final GraphSession session, final GraphFileIdProvider idProvider) {
        this.session = session;
        this.attributes = new GraphAttributesFinderFeature(session);
    }

    @Override
    public AttributedList<Path> search(final Path workdir, final Filter<Path> regex, final ListProgressListener listener) throws BackgroundException {
        final AttributedList<Path> list = new AttributedList<>();

        final DriveItem folder = session.getItem(workdir);

        // The query text used to search for items. Values may be matched across several fields including filename, metadata, and file content.
        final Iterator<DriveItem.Metadata> iterator = Files.search(folder, regex.toPattern().pattern());
        while(iterator.hasNext()) {
            final DriveItem.Metadata metadata;
            try {
                metadata = iterator.next();
            }
            catch(OneDriveRuntimeException e) {
                log.warn(e);
                continue;
            }
            list.add(new Path(String.format("/%s/%s/%s", metadata.getParentReference().getDriveId(), StringUtils.removeStart(metadata.getParentReference().getPath(), "/drive/root:"), metadata.getName()),
                metadata.isFolder() ? EnumSet.of(Path.Type.directory) : EnumSet.of(Path.Type.file),
                attributes.toAttributes(metadata)));
        }
        return list;
    }

    @Override
    public boolean isRecursive() {
        return true;
    }

}
