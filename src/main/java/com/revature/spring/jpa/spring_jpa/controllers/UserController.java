package com.revature.spring.jpa.spring_jpa.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.revature.spring.jpa.spring_jpa.services.UserService;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
