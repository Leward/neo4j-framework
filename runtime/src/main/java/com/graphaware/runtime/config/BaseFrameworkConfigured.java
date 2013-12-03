/*
 * Copyright (c) 2013 GraphAware
 *
 * This file is part of GraphAware.
 *
 * GraphAware is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.graphaware.runtime.config;

/**
 * Convenience base-class for {@link FrameworkConfigured} components.
 */
@SuppressWarnings("UnusedDeclaration") //used by GraphAware modules
public abstract class BaseFrameworkConfigured implements FrameworkConfigured {

    private FrameworkConfiguration configuration;

    /**
     * {@inheritDoc}
     */
    @Override
    public void configurationChanged(FrameworkConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * Get the current configuration of the component.
     *
     * @return current configuration.
     * @throws IllegalStateException if it hasn't been configured yet.
     */
    protected FrameworkConfiguration getConfig() {
        if (configuration == null) {
            throw new IllegalStateException("Component hasn't been configured. Has it been registered with the " +
                    "GraphAware framework?");
        }

        return configuration;
    }
}