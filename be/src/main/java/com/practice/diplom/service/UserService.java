package com.practice.diplom.service;

import com.practice.diplom.dto.JwtResponseDto;
import com.practice.diplom.dto.LoginRequestDto;
import com.practice.diplom.dto.UserRequestDto;
import com.practice.diplom.dto.UserResponseDto;
import com.practice.diplom.dto.UserUpdateRequestDto;
import com.practice.diplom.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Page<UserResponseDto> getAllUsers(Pageable pageable);

    JwtResponseDto createUser(UserRequestDto userRequest);

    JwtResponseDto authenticateUser(LoginRequestDto loginRequest);

    void updateUser(UserUpdateRequestDto newUser, Long id);

    void deleteUser(Long id);

    UserResponseDto getCurrentUser();

    User getUserById(Long id);

    UserResponseDto getUserDtoById(Long id);

    UserResponseDto getUserDtoByEmail(String email);

    User loadUserByUsername(String email);

    void changePassword(String password,Long id);

}
