package com.practice.diplom.service;

import com.practice.diplom.dto.UserRequestDto;
import com.practice.diplom.dto.UserResponseDto;
import com.practice.diplom.entity.User;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    void updateUser(UserRequestDto newUser, Long id);

    void deleteUser(Long id);

    User getUserById(Long id);

    UserResponseDto getUserDtoById(Long id);

    void checkid(Long id);
}
