package com.example.springendpoint.repository;

import com.example.springendpoint.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
