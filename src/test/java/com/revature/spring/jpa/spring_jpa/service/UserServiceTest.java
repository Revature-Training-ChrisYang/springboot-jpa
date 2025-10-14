package com.revature.spring.jpa.spring_jpa.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.spring.jpa.spring_jpa.exception.UserNotFoundException;
import com.revature.spring.jpa.spring_jpa.models.User;
import com.revature.spring.jpa.spring_jpa.repositories.UserRepository;
import com.revature.spring.jpa.spring_jpa.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("jdoe@mail.com");
        user.setPassword("password");

        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.createUser(user);
        assertSame(user, createdUser);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testGetUserById_UserExists() {
        Long userId = 1L;
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("jdoe@mail.com");
        user.setPassword("password");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User foundUser = userService.getUserById(userId);
        assertSame(user, foundUser);
    }

    @Test
    public void testGetUserById_UserNotFound() {
        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.getUserById(userId));
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    public void testDeleteUser_UserExists() {
        Long userId = 1L;
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("jdoe@mail.com");
        user.setPassword("password");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        userService.deleteUser(userId);

        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).delete(user);
    }

    @Test
    public void testDeleteUser_UserNotFound() {
        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.deleteUser(userId));
        verify(userRepository, times(1)).findById(userId);
    }
}
