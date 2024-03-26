package com.practice.diplom.controller;

import com.practice.diplom.dto.UserRequestDto;
import com.practice.diplom.dto.UserResponseDto;
import com.practice.diplom.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "Пользователи",description = "Методы для работы с пользователями")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/all")
    @Operation(summary = "Получение всех зарегистрированных пользователей")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PatchMapping("/update/{id}")
    @Operation(summary = "Изменение пользователя по его id")
    public void updateUser(@RequestBody UserRequestDto userRequestDto, @PathVariable @Parameter(description = "id пользователя")Long id) {
        userService.updateUser(userRequestDto, id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение пользователя по id")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.getUserDtoById(id);
    }
}
