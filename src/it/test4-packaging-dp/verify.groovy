/*******************************************************************************
 * Copyright (c) 2018 Jens Reimann
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann <jreimann@redhat.com> - initial API and implementation
 *******************************************************************************/

def zipFile = new java.util.zip.ZipFile(new File(basedir, "target/test4_0.0.1-SNAPSHOT.dp"))

def entries = new HashSet<String>();
zipFile
        .entries()
        .each{
            entries.add(it.name)
        };

println("Found: " + entries)

return entries.equals(
        [
            "META-INF/MANIFEST.MF",
            "slf4j.api_1.7.36.jar"
        ]
        .toSet());