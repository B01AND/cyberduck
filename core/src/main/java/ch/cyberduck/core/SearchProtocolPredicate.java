package ch.cyberduck.core;

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

import ch.cyberduck.core.profiles.ProfileDescription;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.function.Predicate;

public class SearchProtocolPredicate implements Predicate<Map.Entry<ProfileDescription, Profile>> {

    private final String input;

    public SearchProtocolPredicate(final String input) {
        this.input = input;
    }

    @Override
    public boolean test(final Map.Entry<ProfileDescription, Profile> entry) {
        final Protocol protocol = entry.getValue();
        for(String i : StringUtils.split(input, StringUtils.SPACE)) {
            if(StringUtils.containsIgnoreCase(protocol.getName(), i)
                || StringUtils.containsIgnoreCase(protocol.getDescription(), i)
                || StringUtils.containsIgnoreCase(protocol.getDefaultHostname(), i)
                || StringUtils.containsIgnoreCase(protocol.getProvider(), i)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
