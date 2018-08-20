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
import ch.cyberduck.core.DisabledLoginCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.RandomStringService;
import ch.cyberduck.core.features.Delete;
import ch.cyberduck.core.onedrive.features.OneDriveAttributesFinderFeature;
import ch.cyberduck.core.onedrive.features.OneDriveDeleteFeature;
import ch.cyberduck.core.onedrive.features.OneDriveHomeFinderFeature;
import ch.cyberduck.core.onedrive.features.OneDriveTouchFeature;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.test.IntegrationTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Collections;
import java.util.EnumSet;

import static org.junit.Assert.assertNotNull;

@Category(IntegrationTest.class)
public class OneDriveTouchFeatureTest extends AbstractOneDriveTest {
    private static final Logger log = Logger.getLogger(OneDriveTouchFeatureTest.class);

    @Test
    public void testTouch() throws Exception {
        final OneDriveSession session = session();

        final Path file = new Path(new OneDriveHomeFinderFeature(session).find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        assertNotNull(new OneDriveTouchFeature(session).touch(file, new TransferStatus()).attributes().getVersionId());
        assertNotNull(new OneDriveAttributesFinderFeature(session).find(file));
        new OneDriveDeleteFeature(session).delete(Collections.singletonList(file), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }

    @Test
    public void testTouchUmlaut() throws Exception {
        final OneDriveSession session = session();

        final Path file = new Path(new OneDriveHomeFinderFeature(session).find(), String.format("%sä", new AlphanumericRandomStringService().random()), EnumSet.of(Path.Type.file));
        new OneDriveTouchFeature(session).touch(file, new TransferStatus());
        assertNotNull(new OneDriveAttributesFinderFeature(session).find(file));
        new OneDriveDeleteFeature(session).delete(Collections.singletonList(file), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }

    @Test
    public void testTouchEqualSign() throws Exception {
        final OneDriveSession session = session();

        final Path file = new Path(new OneDriveHomeFinderFeature(session).find(), String.format("%s====", new AlphanumericRandomStringService().random()), EnumSet.of(Path.Type.file));
        new OneDriveTouchFeature(session).touch(file, new TransferStatus());
        assertNotNull(new OneDriveAttributesFinderFeature(session).find(file));
        new OneDriveDeleteFeature(session).delete(Collections.singletonList(file), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }

    @Test
    public void testWhitespaceTouch() throws Exception {
        final OneDriveSession session = session();

        final RandomStringService randomStringService = new AlphanumericRandomStringService();
        final Path file = new Path(new OneDriveHomeFinderFeature(session).find(), String.format("%s %s", randomStringService.random(), randomStringService.random()), EnumSet.of(Path.Type.file));
        new OneDriveTouchFeature(session).touch(file, new TransferStatus().withMime("x-application/cyberduck"));
        assertNotNull(new OneDriveAttributesFinderFeature(session).find(file));
        new OneDriveDeleteFeature(session).delete(Collections.singletonList(file), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }
}
