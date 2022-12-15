package com.example.springendpoint.service;

import com.example.springendpoint.dto.UserDto;
import com.example.springendpoint.mapper.UserMapper;
import com.example.springendpoint.models.User;
import com.example.springendpoint.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public void save(UserDto userDto) {
        Optional.ofNullable(userDto)
                .map(userMapper::toEntity)
                .map(userRepository::save);
    }

    @Override
    public List<UserDto> findAll(Integer page, Integer size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return userRepository.findAll(pageable).stream().map(userMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public UserDto findById(Long id) {
        return Optional.ofNullable(id)
                .flatMap(userRepository::findById)
                .map(userMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Override
    public void update(UserDto userDto, Long id) {
        Optional.ofNullable(id)
                .filter(userRepository::existsById)
                .map(it -> {
                    User user = userMapper.toEntity(userDto);
                    user.setId(it);
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Optional.ofNullable(id)
                .filter(userRepository::existsById)
                .ifPresentOrElse(userRepository::deleteById, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                });

    }
}
