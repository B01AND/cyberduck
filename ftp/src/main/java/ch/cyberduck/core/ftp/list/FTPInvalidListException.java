package ch.cyberduck.core.ftp.list;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
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
import ch.cyberduck.core.Path;
import ch.cyberduck.core.exception.InteroperabilityException;

public class FTPInvalidListException extends InteroperabilityException {
    private static final long serialVersionUID = -231465577746623668L;

    private final AttributedList<Path> parsed;

    public FTPInvalidListException(final AttributedList<Path> parsed) {
        this.parsed = parsed;
    }

    public AttributedList<Path> getParsed() {
        return parsed;
    }
}
