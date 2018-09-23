package com.fv.webfluxdemo

import com.datastax.driver.core.ResultSet
import com.datastax.driver.core.Session
import com.fv.webfluxdemo.configuration.CassandraConfiguration
import org.testcontainers.containers.GenericContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
public class DataBaseTest extends Specification {

    @Shared
    GenericContainer cassandra =
            new GenericContainer("cassandra:3")
                    .withExposedPorts(9042);

    def "check connection to database" () {

        given: "session"
        Session session = CassandraConfiguration.createSession(cassandra.getContainerIpAddress(),
                cassandra.getMappedPort(9042))

        when: "insert user to data base and get it"
        String insert = "INSERT INTO usersKeyspace.user (id, first_name, last_name, date_of_birth) " +
                "VALUES(1001, 'Vasya', 'Pupkin', toDate(now()));" ;
        session.execute(insert);

        and: "read inserted user"

        ResultSet result = session.execute("select * from usersKeyspace.user where id = 1001");

        then: "result is returned"
        result.one().getInt("id") == 1001;

    }
}