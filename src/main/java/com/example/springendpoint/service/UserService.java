package com.example.springendpoint.service;

import com.example.springendpoint.dto.UserDto;

import java.util.List;

public interface UserService {
    /**
     * @param userDto
     */
    void save(UserDto userDto);

    /**
     * @param page, size, sort
     * @return List<UserDto>
     */
    List<UserDto> findAll(Integer page, Integer size, String sort);

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
