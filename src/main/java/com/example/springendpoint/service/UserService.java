package com.example.springendpoint.service;

import com.example.springendpoint.dto.UserDto;

import java.util.List;

public interface UserService {
    /**
     * @param userDto
     */
    void save(UserDto userDto);

    /**
     * @return List<UserDto>
     */
    List<UserDto> findAll();

    /**
     * @param id
     * @return UserDto
     */
    UserDto findById(Long id);

    /**
     * @param userDto, id
     */
    void update(UserDto userDto, Long id);

    /**
     * @param id
     */
    void deleteById(Long id);
}
