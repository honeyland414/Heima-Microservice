package com.example.userservice.controller;

import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;
    private Counter counter_core;
    private final MeterRegistry registry;


    @Autowired
    public UserController(UserService userService, MeterRegistry registry) {
        this.userService = userService;
        this.registry = registry;
    }

    @PostConstruct
    private void init(){
        counter_core = registry.counter("my_count", "method", "IndexController.core");
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        counter_core.increment();
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.getUserById(id);
        return user.orElse(null);
    }
}
