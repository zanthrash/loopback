package com.loopback

import grails.plugin.spock.UnitSpec
import spock.lang.Unroll

class ParameterizedSpec extends UnitSpec{

    @Unroll("#a + #b = #c")
    def "summation of 2 numbers"() {
        expect: a + b == c

        where:
            a |b  |c
            1 |1  |2
            2 |1  |3
            3 |2  |5
    }
}
