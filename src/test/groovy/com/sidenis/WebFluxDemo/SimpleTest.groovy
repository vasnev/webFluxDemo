package com.sidenis

import spock.lang.Specification;

public class SimpleTest extends Specification {

    def "an integer can be incremented"() {

        given:
        int i = 1;
        when:
        i++
        then:
        i == 2

    }
}