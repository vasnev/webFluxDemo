package com.sidenis.reactiveuser;

import com.sidenis.reactiveuser.user.dao.UserRepository;
import com.sidenis.reactiveuser.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WebFluxDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxDemoApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.saveAll(Arrays.asList(
                User.builder().id(101L)
                        .firstName("John")
                        .lastName("Peterson")
                        .dateOfBirth(LocalDate.of(1998, 2, 12))
                        .build(),
                User.builder().id(102L)
                        .firstName("Smith")
                        .lastName("White")
                        .dateOfBirth(LocalDate.of(1990, 11, 10))
                        .build(),
                User.builder().id(103L)
                        .firstName("Peter").lastName("Black")
                        .dateOfBirth(LocalDate.of(1980, 12, 12))
                        .build()))
                .subscribe(System.out::println);

    }
}
