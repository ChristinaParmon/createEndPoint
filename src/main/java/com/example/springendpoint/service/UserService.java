package com.example.springendpoint.service;

import com.example.springendpoint.models.User;

import java.util.List;

public interface UserService {
    void create(User user);

    List<User> readAll();

    User read(Long id);

    boolean update(User client, Long id);

    boolean delete(Long id);
}
