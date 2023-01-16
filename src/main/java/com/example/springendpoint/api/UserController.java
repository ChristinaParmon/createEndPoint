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

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(value = "/{userId}/{photoId}")
    public ResponseEntity<UserDto> savePhoto(@PathVariable(name = "userId") Long userId,
                                             @PathVariable(name = "photoId") String photoId) {
        UserDto userDto = userService.findById(userId);
        userDto.setPhotoId(photoId);
        userService.update(userDto, userId);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(@RequestParam(required = false, defaultValue = "0") final Integer page,
                                                 @RequestParam(required = false, defaultValue = "5") final Integer size,
                                                 @RequestParam(required = false, defaultValue = "id") final String sort) {
        return ResponseEntity.ok(userService.findAll(page, size, sort));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> update(@PathVariable(name = "id") Long id, @RequestBody UserDto userDto) {
        userService.update(userDto, id);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDto> deleteById(@PathVariable(name = "id") Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}