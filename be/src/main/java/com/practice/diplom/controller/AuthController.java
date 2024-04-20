package com.practice.diplom.controller;

import com.practice.diplom.dto.JwtResponseDto;
import com.practice.diplom.dto.LoginRequestDto;
import com.practice.diplom.dto.UserRequestDto;
import com.practice.diplom.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@Validated
@RequestMapping("/auth")
@Tag(name = "Авторизация", description = "Все методы для работы с пользователями")
public class AuthController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Авторизация пользователя в систему")
    @PostMapping("/signin")
    public JwtResponseDto authenticateUser(@Valid @RequestBody LoginRequestDto loginRequest) {
        return userService.authenticateUser(loginRequest);
    }
    @Operation(summary = "Авторизация пользователя в систему")
    @PostMapping("/new")
    public JwtResponseDto registerUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }
}