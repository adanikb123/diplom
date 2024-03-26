package com.practice.diplom.controller;

import com.practice.diplom.dto.UserRequestDto;
import com.practice.diplom.dto.UserResponseDto;
import com.practice.diplom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PatchMapping("/update/{id}")
    public void updateUser(@RequestBody UserRequestDto userRequestDto, @PathVariable Long id) {
        userService.updateUser(userRequestDto, id);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.getUserDtoById(id);
    }
}
