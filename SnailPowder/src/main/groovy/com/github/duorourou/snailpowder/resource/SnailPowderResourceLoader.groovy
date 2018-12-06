package com.github.duorourou.snailpowder.resource

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class SnailPowderResourceLoader {

    def final fixtureFiles = new ArrayList<Path>()

    def loadDataFiles() {
        Files.walk(Paths.get(Configuration.getFixturePath()))
                .filter { p -> !Files.isDirectory(p) }
                .filter { p -> p.getFileName().toString().endsWith(Configuration.getFixtureFileExtension()) }
                .forEach(fixtureFiles.&add)
    }
}
