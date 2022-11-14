package com.example.springendpoint.api;

import com.example.springendpoint.dto.UserDto;
import com.example.springendpoint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> findAll() {
        final List<UserDto> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable(name = "id") Long id) {
        final UserDto userDto = userService.findById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody UserDto userDto) {
        userService.update(userDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}