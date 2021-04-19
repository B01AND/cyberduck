package ch.cyberduck.core.onedrive;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
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
 */

import ch.cyberduck.core.AlphanumericRandomStringService;
import ch.cyberduck.core.DisabledConnectionCallback;
import ch.cyberduck.core.DisabledLoginCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.features.AttributesFinder;
import ch.cyberduck.core.features.Copy;
import ch.cyberduck.core.features.Delete;
import ch.cyberduck.core.features.Directory;
import ch.cyberduck.core.features.Find;
import ch.cyberduck.core.features.Touch;
import ch.cyberduck.core.onedrive.features.GraphAttributesFinderFeature;
import ch.cyberduck.core.onedrive.features.GraphCopyFeature;
import ch.cyberduck.core.onedrive.features.GraphDeleteFeature;
import ch.cyberduck.core.onedrive.features.GraphDirectoryFeature;
import ch.cyberduck.core.onedrive.features.GraphFileIdProvider;
import ch.cyberduck.core.onedrive.features.GraphTouchFeature;
import ch.cyberduck.core.shared.DefaultFindFeature;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.test.IntegrationTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Arrays;
import java.util.EnumSet;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Category(IntegrationTest.class)
public class GraphCopyFeatureTest extends AbstractOneDriveTest {

    @Test
    public void testCopy() throws Exception {
        final Directory directory = new GraphDirectoryFeature(session, new GraphFileIdProvider(session));
        final Touch touch = new GraphTouchFeature(session, new GraphFileIdProvider(session));
        final Copy copy = new GraphCopyFeature(session, new GraphFileIdProvider(session));
        final Delete delete = new GraphDeleteFeature(session);
        final AttributesFinder attributesFinder = new GraphAttributesFinderFeature(session);
        final Path drive = new OneDriveHomeFinderService().find();
        Path targetDirectory = new Path(drive, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory));
        directory.mkdir(targetDirectory, null, null);
        assertNotNull(attributesFinder.find(targetDirectory));

        Path touchedFile = new Path(drive, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        touch.touch(touchedFile, new TransferStatus().withMime("x-application/cyberduck"));
        assertNotNull(attributesFinder.find(touchedFile));

        Path rename = new Path(targetDirectory, touchedFile.getName(), EnumSet.of(Path.Type.file));
        assertTrue(copy.isSupported(touchedFile, rename));
        copy.copy(touchedFile, rename, new TransferStatus(), new DisabledConnectionCallback());

        assertNotNull(attributesFinder.find(rename));

        delete.delete(Arrays.asList(touchedFile, targetDirectory), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }

    @Test
    public void testCopyToExistingFile() throws Exception {
        final Path folder = new GraphDirectoryFeature(session, new GraphFileIdProvider(session)).mkdir(new Path(new OneDriveHomeFinderService().find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory)), null, new TransferStatus());
        final Path test = new GraphTouchFeature(session, new GraphFileIdProvider(session)).touch(new Path(folder, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file)), new TransferStatus());
        final String target = new AlphanumericRandomStringService().random();
        final Path copy = new GraphTouchFeature(session, new GraphFileIdProvider(session)).touch(new Path(folder, target, EnumSet.of(Path.Type.file)), new TransferStatus());
        new GraphCopyFeature(session, new GraphFileIdProvider(session)).copy(test, new Path(folder, target, EnumSet.of(Path.Type.file)), new TransferStatus().exists(true), new DisabledConnectionCallback());
        final Find find = new DefaultFindFeature(session);
        assertTrue(find.find(test));
        assertTrue(find.find(copy));
        new GraphDeleteFeature(session).delete(Arrays.asList(test, new Path(folder, target, EnumSet.of(Path.Type.file))), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }
}
