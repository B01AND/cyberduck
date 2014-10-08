package ch.cyberduck.core.ftp;

/*
 * Copyright (c) 2002-2014 David Kocher. All rights reserved.
 * http://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.io
 */

import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.Cache;
import ch.cyberduck.core.DisabledListProgressListener;
import ch.cyberduck.core.DisabledProgressListener;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.NotfoundException;
import ch.cyberduck.core.features.Attributes;

import org.apache.commons.net.ftp.FTPCmd;

import java.io.IOException;
import java.util.List;

/**
 * @version $Id$
 */
public class FTPAttributesFeature implements Attributes {

    private FTPSession session;

    public FTPAttributesFeature(FTPSession session) {
        this.session = session;
    }

    @Override
    public PathAttributes find(final Path file) throws BackgroundException {
        try {
            final List<String> list = new FTPDataFallback(session).data(file, new DataConnectionAction<List<String>>() {
                @Override
                public List<String> execute() throws BackgroundException {
                    try {
                        return session.getClient().list(FTPCmd.MLST);
                    }
                    catch(IOException e) {
                        throw new FTPExceptionMappingService().map(e);
                    }
                }
            }, new DisabledProgressListener());
            final FTPDataResponseReader reader = new FTPMlsdListResponseReader();
            final AttributedList<Path> attributes
                    = reader.read(file.getParent(), list, new DisabledListProgressListener());
            if(attributes.size() == 1) {
                return attributes.iterator().next().attributes();
            }
            throw new NotfoundException(file.getAbsolute());
        }
        catch(IOException e) {
            throw new FTPExceptionMappingService().map(e);
        }
    }

    @Override
    public Attributes withCache(Cache<Path> cache) {
        return this;
    }
}
