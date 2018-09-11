package com.sidenis

import spock.lang.Specification
import user.User;

public class SimpleTest extends Specification {

    def "a user can follow another user"() {
        given:
        def user = new User()
        user.setName("Vasya")

        def other = new User()
        other.setName("Petya")
        when:
        user.follow(other)
        then:
        user.getFollowers().size() == 1
        user.getFollowers().contains(other)
    }

    def "a new user is not following anyone"() {
        given:
        def user = User.builder().name("Petr").followers(new ArrayList<User>()).build();
        expect:
        user.getFollowers().isEmpty()
    }
}