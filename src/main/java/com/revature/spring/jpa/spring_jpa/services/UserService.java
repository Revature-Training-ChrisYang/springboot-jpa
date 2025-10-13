package com.revature.spring.jpa.spring_jpa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.spring.jpa.spring_jpa.exception.UserNotFoundException;
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
        return userRepository.findById(id).orElseThrow(
            () -> new UserNotFoundException("User with ID " + id + " not found")
        );
    }

    public List<User> getUserByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
