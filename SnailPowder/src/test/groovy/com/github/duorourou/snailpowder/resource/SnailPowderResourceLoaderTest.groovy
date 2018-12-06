package com.github.duorourou.snailpowder.resource

import spock.lang.Specification

class SnailPowderResourceLoaderTest extends Specification {

    def "resource loader will load test data files"() {
        def resourceLoader = new SnailPowderResourceLoader()
        given: 'data files in fixture directory'

        when: 'resourceLoader loaded data files'
        resourceLoader.loadDataFiles()

        then: 'all files were found'
        !resourceLoader.fixtureFiles.isEmpty()
        resourceLoader.fixtureFiles.stream()
                .map { p -> p.toString() }
                .filter { p -> p == path }
                .findFirst().isPresent() == inDataSet


        where:
        path                                                      | inDataSet
        'src/test/resources/fixture/test.'                        | false
        'src/test/resources/fixture/test.json'                    | true
        'src/test/resources/fixture/snailpowder/snailpowder.json' | true

    }
}
