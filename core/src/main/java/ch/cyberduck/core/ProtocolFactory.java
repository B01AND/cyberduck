package ch.cyberduck.core;

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

import ch.cyberduck.core.exception.AccessDeniedException;
import ch.cyberduck.core.local.DefaultLocalDirectoryFeature;
import ch.cyberduck.core.preferences.ApplicationResourcesFinderFactory;
import ch.cyberduck.core.preferences.Preferences;
import ch.cyberduck.core.preferences.PreferencesFactory;
import ch.cyberduck.core.preferences.SupportDirectoryFinderFactory;
import ch.cyberduck.core.profiles.LocalProfilesFinder;
import ch.cyberduck.core.profiles.ProfileDescription;
import ch.cyberduck.core.profiles.ProfilesFinder;
import ch.cyberduck.core.serializer.impl.dd.ProfilePlistReader;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class ProtocolFactory {
    private static final Logger log = Logger.getLogger(ProtocolFactory.class);

    private static final ProtocolFactory global = new ProtocolFactory();

    private final Preferences preferences = PreferencesFactory.get();

    public static ProtocolFactory get() {
        return global;
    }

    private final Set<Protocol> registered;
    private final Local bundle;

    public ProtocolFactory() {
        this(new LinkedHashSet<>());
    }

    public ProtocolFactory(final Set<Protocol> protocols) {
        this(LocalFactory.get(ApplicationResourcesFinderFactory.get().find(),
            PreferencesFactory.get().getProperty("profiles.folder.name")), protocols);
    }

    public ProtocolFactory(final Local bundle, final Set<Protocol> protocols) {
        this.bundle = bundle;
        this.registered = protocols;
    }

    public void register(Protocol... protocols) {
        if(log.isInfoEnabled()) {
            log.info(String.format("Register protocols %s", protocols));
        }
        // Order determines list in connection dropdown
        Collections.addAll(registered, protocols);
    }

    /**
     * Load profiles embedded in bundles and installed in the application support directory.
     */
    public void load() {
        this.load(new LocalProfilesFinder(bundle));
        // Load thirdparty protocols
        this.load(new LocalProfilesFinder());
    }

    /**
     * Load all profiles found
     *
     * @param finder Finder to locate profiles
     */
    public void load(final ProfilesFinder finder) {
        try {
            final ProfilePlistReader reader = new ProfilePlistReader(this);
            for(ProfileDescription description : finder.find()) {
                Local e = description.getProfile();
                if(e != null) {
                    try {
                        registered.add(reader.read(e));
                    }
                    catch(AccessDeniedException f) {
                        log.warn(String.format("Failure %s reading profile %s", e, e));
                    }
                }
            }
        }
        catch(AccessDeniedException e) {
            log.warn(String.format("Failure %s reading profiles from %s", finder, e));
        }
    }

    /**
     * Register profile and write to application support directory
     *
     * @param file Profile
     */
    public void register(final Local file) {
        try {
            final Profile profile = new ProfilePlistReader(this).read(file);
            if(null == profile) {
                log.error("Attempt to register unknown protocol");
                return;
            }
            if(log.isInfoEnabled()) {
                log.info(String.format("Register profile %s", profile));
            }
            registered.add(profile);
            preferences.setProperty(String.format("profiles.%s.%s.enabled", profile.getName(), profile.getProvider()), true);
            final Local directory = LocalFactory.get(SupportDirectoryFinderFactory.get().find(),
                PreferencesFactory.get().getProperty("profiles.folder.name"));
            if(!directory.exists()) {
                new DefaultLocalDirectoryFeature().mkdir(directory);
            }
            if(log.isDebugEnabled()) {
                log.debug(String.format("Save profile %s to %s", profile, directory));
            }
            file.copy(LocalFactory.get(directory, file.getName()));
        }
        catch(AccessDeniedException e) {
            log.error(String.format("Failure %s reading profile %s", e, file));
        }
    }

    public void unregister(final Profile profile) {
        if(registered.remove(profile)) {
            preferences.setProperty(String.format("profiles.%s.%s.enabled", profile.getName(), profile.getProvider()), false);
        }
        else {
            log.warn(String.format("Failure removing protocol %s", profile));
        }
    }

    /**
     * @return List of enabled protocols
     */
    public List<Protocol> find() {
        return this.find(Protocol::isEnabled);
    }

    /**
     * @param search Search filter for all registered protocols
     * @return List of registered protocols matching search criteria.
     */
    public List<Protocol> find(final Predicate<Protocol> search) {
        return registered.stream().filter(search).sorted().collect(Collectors.toList());
    }

    /**
     * @param identifier Serialized protocol reference or scheme
     * @return Matching protocol or null if no match
     */
    public Protocol forName(final String identifier) {
        return this.forName(identifier, null);
    }

    /**
     * @param identifier Serialized protocol reference or scheme
     * @param provider   Custom inherited protocol definition
     * @return Matching protocol or null if no match
     */
    public Protocol forName(final String identifier, final String provider) {
        return this.forName(this.find(), identifier, provider);
    }

    /**
     * @param enabled    List of protocols
     * @param identifier Serialized protocol reference or scheme
     * @param provider   Custom inherited protocol definition
     * @return Matching protocol or null if no match
     */
    public Protocol forName(final List<Protocol> enabled, final String identifier, final String provider) {
        final Protocol match =
            // Exact match with hash code
            enabled.stream().filter(protocol -> String.valueOf(protocol.hashCode()).equals(identifier)).findFirst().orElse(
                // Matching vendor string for third party profiles
                enabled.stream().filter(protocol -> StringUtils.equals(protocol.getIdentifier(), identifier) && StringUtils.equals(protocol.getProvider(), provider)).findFirst().orElse(
                    // Matching vendor string usage in CLI
                    enabled.stream().filter(protocol -> StringUtils.equals(protocol.getProvider(), identifier)).findFirst().orElse(
                        // Fallback for bug in 6.1
                        enabled.stream().filter(protocol -> StringUtils.equals(String.format("%s-%s", protocol.getIdentifier(), protocol.getProvider()), identifier)).findFirst().orElse(
                            // Matching scheme with fallback to generic protocol type
                            this.forScheme(enabled, identifier, enabled.stream().filter(protocol -> StringUtils.equals(protocol.getType().name(), identifier)).findFirst().orElse(null))
                        )
                    )
                )
            );
        if(null == match) {
            if(enabled.isEmpty()) {
                log.error(String.format("List of registered protocols in %s is empty", this));
            }
            log.error(String.format("Missing registered protocol for identifier %s", identifier));
        }
        return match;
    }

    public Protocol forType(final Protocol.Type type) {
        final List<Protocol> enabled = this.find();
        return this.forType(enabled, type);
    }

    private Protocol forType(final List<Protocol> enabled, final Protocol.Type type) {
        return enabled.stream().filter(protocol -> protocol.getType().equals(type)).findFirst().orElse(null);
    }

    public Protocol forScheme(final Scheme scheme) {
        return this.forScheme(scheme.name(), null);
    }

    public Protocol forScheme(final String scheme, final Protocol fallback) {
        return this.forScheme(this.find(), scheme, fallback);
    }

    private Protocol forScheme(final List<Protocol> enabled, final String scheme, final Protocol fallback) {
        final String filter;
        switch(scheme) {
            case "http":
                filter = Scheme.dav.name();
                break;
            case "https":
                filter = Scheme.davs.name();
                break;
            default:
                filter = scheme;
                break;
        }
        return enabled.stream().filter(protocol -> Arrays.asList(protocol.getSchemes()).contains(filter)).findFirst().orElse(
            enabled.stream().filter(protocol -> Arrays.asList(protocol.getSchemes()).contains(scheme)).findFirst().orElse(fallback)
        );
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProtocolFactory{");
        sb.append("registered=").append(registered);
        sb.append(", bundle=").append(bundle);
        sb.append('}');
        return sb.toString();
    }
}
