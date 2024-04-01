package com.practice.diplom.controller;

import com.practice.diplom.dto.UserRequestDto;
import com.practice.diplom.dto.UserResponseDto;
import com.practice.diplom.entity.User;
import com.practice.diplom.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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
@Validated
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/user")
@Tag(name = "Пользователи",description = "Методы для работы с пользователями")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @Operation(summary = "Получение всех зарегистрированных пользователей")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PatchMapping("/update/{id}")
    @Operation(summary = "Изменение пользователя по его id")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public void updateUser(@Valid @RequestBody UserRequestDto userRequestDto, @PathVariable @Parameter(description = "id пользователя")Long id) {
        userService.updateUser(userRequestDto, id);
    }
    @PatchMapping("/update/{id}/password")
    @Operation(summary = "Изменение пароля текущего пользователя ")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public void changePasswordUser(@Size(min = 6, message = "Пароль должен быть больше 6 символов") @RequestBody String newPassord) {
        userService.changePassword(newPassord);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение пользователя по id")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.getUserDtoById(id);
    }

    @Operation(summary = "Получить текущего пользователя")
    @PreAuthorize("hasAnyAuthority('USER', 'MODER', 'ADMIN')")
    @GetMapping("")
    public UserResponseDto getCurrentUser() {
        return userService.getCurrentUser();
    }
}
