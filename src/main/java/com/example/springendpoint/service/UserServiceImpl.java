package com.example.springendpoint.service;

import com.example.springendpoint.models.User;
import com.example.springendpoint.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void save(User user) {
        Optional.ofNullable(user)
                .map(userRepository::save);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return Optional.ofNullable(id)
                .flatMap(userRepository::findById)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void update(User client, Long id) {
        Optional.ofNullable(id)
                .filter(userRepository::existsById)
                .map(it -> {
                    client.setId(it);
                    return userRepository.save(client);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Override
    public void deleteById(Long id) {
        Optional.ofNullable(id)
                .filter(userRepository::existsById)
                .ifPresentOrElse(userRepository::deleteById, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                });

    }
}
