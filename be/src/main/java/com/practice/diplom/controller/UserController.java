package com.practice.diplom.controller;

import com.practice.diplom.dto.ChangePasswordRequestDto;
import com.practice.diplom.dto.UserResponseDto;
import com.practice.diplom.dto.UserUpdateRequestDto;
import com.practice.diplom.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Validated
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/user")
@Tag(name = "Пользователи", description = "Методы для работы с пользователями")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @Operation(summary = "Получение всех зарегистрированных пользователей")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Page<UserResponseDto> getAllUsers(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @PatchMapping("/update/{id}")
    @Operation(summary = "Изменение пользователя по его id")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public void updateUser(
            @Valid @RequestBody UserUpdateRequestDto userRequestDto,
            @PathVariable @Parameter(description = "id пользователя") Long id) {
        userService.updateUser(userRequestDto, id);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удаление пользователя по его id")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public void deleteUser(
            @PathVariable @Parameter(description = "id пользователя") Long id) {
        userService.deleteUser(id);
    }

    @PatchMapping("/update/password/{id}")
    @Operation(summary = "Изменение пароля текущего пользователя ")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public void changePasswordUser(@Valid @RequestBody ChangePasswordRequestDto changePasswordRequest,
                                   @PathVariable Long id) {
        System.out.println("qq");
        userService.changePassword(changePasswordRequest.getPassword(), id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение пользователя по id")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.getUserDtoById(id);
    }

    @GetMapping("/find/{email}")
    @Operation(summary = "Получение пользователя по id")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public UserResponseDto getUserByEmail(@PathVariable String email) {
        return userService.getUserDtoByEmail(email);
    }


    @Operation(summary = "Получить текущего пользователя")
    @PreAuthorize("hasAnyAuthority('USER', 'MODER', 'ADMIN')")
    @GetMapping("")
    public UserResponseDto getCurrentUser() {
        return userService.getCurrentUser();
    }
}
