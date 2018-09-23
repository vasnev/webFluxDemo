package com.fv.webfluxdemo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * Created by dell on 18.09.18.
 */

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractReactiveCassandraConfiguration {

    @Value("${cassandra.contactpoints}") private String contactPoints;
    @Value("${cassandra.port}") private int port;
    @Value("${cassandra.keyspace}") private String keyspace;
    @Value("${cassandra.basepackages}") private String basePackages;
    @Override protected String getKeyspaceName() {
        return keyspace;
    }
    @Override protected String getContactPoints() {
        return contactPoints;
    }
    @Override protected int getPort() {
        return port;
    }
    @Override public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }
    @Override public String[] getEntityBasePackages() {
        return new String[] {
                basePackages
        };
    }

}
