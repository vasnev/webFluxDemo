package com.sidenis.reactiveuser.user.controller;

import com.sidenis.reactiveuser.user.dao.UserRepository;
import com.sidenis.reactiveuser.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by dell on 18.09.18.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    private Mono<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @GetMapping
    private Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @PutMapping
//    private Flux<User> saveUser(@RequestBody User user) {
//        return userRepository.save(user);
//    }
}
