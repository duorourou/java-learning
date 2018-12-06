package com.github.duorourou.snailpowder.resource

import spock.lang.Specification


class ConfigurationTest extends Specification {

    void setup() {
        System.setProperty(Configuration.FIXTURE_PATH_KEY, "")
    }

    void cleanup() {
    }

    def "configuration will use the given path"() {
        given: 'customized path configuration'
        System.setProperty(Configuration.FIXTURE_PATH_KEY, path)

        when: 'resourceLoader initialized'

        then: 'fixture path has been initialized'
        expect == Configuration.fixturePath

        where:
        path                         | expect
        ''                           | 'src/test/resources/fixture'
        'src/test/resources/fixture' | 'src/test/resources/fixture'
        'src/test/resources/data'    | 'src/test/resources/data'

    }
}
