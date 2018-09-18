package com.sidenis.reactiveuser.user.dao;

import com.sidenis.reactiveuser.user.pojo.User;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by dell on 18.09.18.
 */

@Repository
public interface UserRepository extends ReactiveCassandraRepository<User, Long> {

}