package com.fv.webfluxdemo.user;

import org.reactivestreams.Publisher;
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

    @PostMapping
    private Flux<User> saveUser(@RequestBody Publisher<User> user) {
        return userRepository.insert(user);
    }
}
