package com.baron.Baron.TodoList.controllers;

import com.baron.Baron.TodoList.dto.user.CreateUserDto;
import com.baron.Baron.TodoList.dto.user.UserDto;
import com.baron.Baron.TodoList.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/my_profile")
    public ResponseEntity<UserDto> findUserById(Authentication authentication) {
        UserDto userDto = userService.findByUsername(authentication.getName());
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {
        List<UserDto> dtoList = userService.findAll();
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        UserDto userDto = userService.create(createUserDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUSer(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
