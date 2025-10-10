package com.revature.spring.jpa.spring_jpa.services;

import org.springframework.stereotype.Service;

import com.revature.spring.jpa.spring_jpa.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
