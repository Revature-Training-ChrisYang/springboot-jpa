package com.revature.spring.jpa.spring_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.spring.jpa.spring_jpa.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
