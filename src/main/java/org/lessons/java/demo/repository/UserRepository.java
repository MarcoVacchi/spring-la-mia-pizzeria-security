package org.lessons.java.demo.repository;

import java.util.Optional;

import org.lessons.java.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
