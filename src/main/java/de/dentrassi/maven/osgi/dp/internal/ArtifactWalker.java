/*******************************************************************************
 * Copyright (c) 2016 Jens Reimann.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann <jreimann@redhat.com> - initial API and implementation
 *******************************************************************************/
package de.dentrassi.maven.osgi.dp.internal;

import java.io.IOException;
import java.nio.file.Path;

public interface ArtifactWalker {
    class Entry {
        private final Path location;

        public Entry(final Path location) {
            this.location = location;
        }

        public Path getLocation() {
            return this.location;
        }
    }

    @FunctionalInterface
    interface ArtifactConsumer {
        void accept(Entry entry) throws IOException;
    }

    void walk(ArtifactConsumer consumer);
}
