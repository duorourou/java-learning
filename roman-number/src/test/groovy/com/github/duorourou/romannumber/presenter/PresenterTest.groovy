package com.github.duorourou.romannumber.presenter

import spock.lang.Specification

class PresenterTest extends Specification {


    def "combine 2 list as a list"() {
        def presenter = new Presenter()
        expect:
        presenter.combine(one, another) == combine

        where:
        one | another      | combine
        [[
                 " ", "-", " "
         ], [
                 "|", " ", "|"
         ], [
                 " ", " ", " "
         ], [
                 "|", " ", "|"
         ], [
                 " ", "-", " "
         ]] |
                [
                        [
                                " ", " ", " "
                        ], [
                                " ", " ", "|"
                        ], [
                                " ", " ", " "
                        ], [
                                " ", " ", "|"
                        ], [
                                " ", " ", " "
                        ]] | [[
                                      " ", "-", " ", " ", " ", " "
                              ], [
                                      "|", " ", "|", " ", " ", "|"
                              ], [
                                      " ", " ", " ", " ", " ", " "
                              ], [
                                      "|", " ", "|", " ", " ", "|"
                              ], [
                                      " ", "-", " ", " ", " ", " "
                              ]]
    }

    def "reduce a 2-dimension string list as a string list"() {
        def presenter = new Presenter()
        expect:
        presenter.contact(twoDimensionList) == result

        where:
        twoDimensionList | result
        [[
                 " ", "-", " ", " ", " ", " "
         ], [
                 "|", " ", "|", " ", " ", "|"
         ], [
                 " ", " ", " ", " ", " ", " "
         ], [
                 "|", " ", "|", " ", " ", "|"
         ], [
                 " ", "-", " ", " ", " ", " "
         ]]              |
                [
                        " -    ",
                        "| |  |",
                        "      ",
                        "| |  |",
                        " -    "
                ]
    }
}
