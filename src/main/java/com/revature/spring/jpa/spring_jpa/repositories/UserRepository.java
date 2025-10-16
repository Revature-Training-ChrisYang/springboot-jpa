package com.revature.spring.jpa.spring_jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.spring.jpa.spring_jpa.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByLastName(String lastName);
    boolean existsByEmail(String email);
    User findByEmail(String email);
}
