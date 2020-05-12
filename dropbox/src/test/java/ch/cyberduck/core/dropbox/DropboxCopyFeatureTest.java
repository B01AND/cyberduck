package ch.cyberduck.core.dropbox;

/*
 * Copyright (c) 2002-2016 iterate GmbH. All rights reserved.
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

import ch.cyberduck.core.AbstractDropboxTest;
import ch.cyberduck.core.AlphanumericRandomStringService;
import ch.cyberduck.core.DisabledConnectionCallback;
import ch.cyberduck.core.DisabledLoginCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.features.Delete;
import ch.cyberduck.core.features.Find;
import ch.cyberduck.core.shared.DefaultFindFeature;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.test.IntegrationTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;

import static org.junit.Assert.assertTrue;

@Category(IntegrationTest.class)
public class DropboxCopyFeatureTest extends AbstractDropboxTest {

    @Test
    public void testCopyFile() throws Exception {
        final Path file = new Path(new DropboxHomeFinderFeature(session).find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        final Path target = new Path(new DropboxHomeFinderFeature(session).find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        new DropboxTouchFeature(session).touch(file, new TransferStatus());
        assertTrue(new DropboxFindFeature(session).find(file));
        new DropboxCopyFeature(session).copy(file, target, new TransferStatus(), new DisabledConnectionCallback());
        assertTrue(new DropboxFindFeature(session).find(file));
        assertTrue(new DropboxFindFeature(session).find(target));
        new DropboxDeleteFeature(session).delete(Collections.singletonList(target), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }

    @Test
    public void testCopyToExistingFile() throws Exception {
        final Path folder = new DropboxDirectoryFeature(session).mkdir(
            new Path(new DropboxHomeFinderFeature(session).find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory)), null, new TransferStatus());
        final Path test = new DropboxTouchFeature(session).touch(
            new Path(folder, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file)), new TransferStatus());
        final Path copy = new Path(folder, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        new DropboxTouchFeature(session).touch(copy, new TransferStatus());
        new DropboxCopyFeature(session).copy(test, copy, new TransferStatus().exists(true), new DisabledConnectionCallback());
        final Find find = new DefaultFindFeature(session);
        assertTrue(find.find(test));
        assertTrue(find.find(copy));
        new DropboxDeleteFeature(session).delete(Arrays.asList(test, copy), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }

    @Test
    public void testCopyDirectory() throws Exception {
        final Path directory = new DropboxDirectoryFeature(session).mkdir(
            new Path(new DropboxHomeFinderFeature(session).find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory)), null, new TransferStatus());
        final String name = new AlphanumericRandomStringService().random();
        final Path file = new DropboxTouchFeature(session).touch(
            new Path(directory, name, EnumSet.of(Path.Type.file)), new TransferStatus());
        assertTrue(new DropboxFindFeature(session).find(file));
        final Path copy = new Path(new DropboxHomeFinderFeature(session).find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory));
        new DropboxCopyFeature(session).copy(directory, copy, new TransferStatus(), new DisabledConnectionCallback());
        assertTrue(new DropboxFindFeature(session).find(file));
        assertTrue(new DropboxFindFeature(session).find(copy));
        assertTrue(new DropboxFindFeature(session).find(new Path(copy, name, EnumSet.of(Path.Type.file))));
        new DropboxDeleteFeature(session).delete(Arrays.asList(directory, copy), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }
}
