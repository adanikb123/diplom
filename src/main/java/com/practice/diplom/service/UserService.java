package com.practice.diplom.service;

import com.practice.diplom.dto.JwtResponseDto;
import com.practice.diplom.dto.LoginRequestDto;
import com.practice.diplom.dto.UserRequestDto;
import com.practice.diplom.dto.UserResponseDto;
import com.practice.diplom.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserResponseDto> getAllUsers();

    JwtResponseDto createUser(UserRequestDto userRequest);

    JwtResponseDto authenticateUser(LoginRequestDto loginRequest);

    void updateUser(UserRequestDto newUser, Long id);

    void deleteUser(Long id);

    UserResponseDto getCurrentUser();

    User getUserById(Long id);

    UserResponseDto getUserDtoById(Long id);

    User loadUserByUsername(String email);

    void changePassword(String password);

    void checkid(Long id);
}
