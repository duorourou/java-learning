package com.github.duorourou.snailpowder.resource

import com.google.common.base.Strings

class Configuration {
    public static final String FIXTURE_PATH_KEY = "snailpowder.test.fixture.path"
    public static final String FIXTURE_PATH_VALUE = "src/test/resources/fixture"
    public static final String FIXTURE_FILE_TYPE_KEY = "snailpowder.test.fixture.file.extension"
    public static final String FIXTURE_FILE_TYPE_VALUE = ".json"

    static String getFixturePath() {
        final String customizedFixturePath = System.getProperty(FIXTURE_PATH_KEY)
        return Strings.isNullOrEmpty(customizedFixturePath) ? FIXTURE_PATH_VALUE : customizedFixturePath
    }

    static String getFixtureFileExtension() {
        final String customizedType = System.getProperty(FIXTURE_FILE_TYPE_KEY)
        return Strings.isNullOrEmpty(customizedType) ? FIXTURE_FILE_TYPE_VALUE : customizedType
    }
}