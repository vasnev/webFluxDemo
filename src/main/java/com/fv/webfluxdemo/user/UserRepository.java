package com.fv.webfluxdemo.user;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dell on 18.09.18.
 */

@Repository
public interface UserRepository extends ReactiveCassandraRepository<User, Long> {

}