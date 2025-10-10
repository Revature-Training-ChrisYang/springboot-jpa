package com.revature.spring.jpa.spring_jpa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.spring.jpa.spring_jpa.models.User;
import com.revature.spring.jpa.spring_jpa.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
