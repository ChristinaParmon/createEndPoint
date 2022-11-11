package com.example.springendpoint.service;

import com.example.springendpoint.models.User;

import java.util.List;

public interface UserService {
    /**
     * @param user
     */
    void save(User user);

    /**
     * @return List<User>
     */
    List<User> findAll();

    /**
     * @param id
     * @return User
     */
    User findById(Long id);

    /**
     * @param client, id
     */
    void update(User client, Long id);

    /**
     * @param id
     */
    void deleteById(Long id);
}
