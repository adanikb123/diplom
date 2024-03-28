package com.practice.diplom.service.implementation;

import com.practice.diplom.dto.UserRequestDto;
import com.practice.diplom.dto.UserResponseDto;
import com.practice.diplom.entity.User;
import com.practice.diplom.exception.NotFoundException;
import com.practice.diplom.mapper.UserMapper;
import com.practice.diplom.repository.UserRepository;
import com.practice.diplom.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<UserResponseDto> getAllUsers() {
        return userMapper.toResponseDtos(userRepository.findAll());
    }

    @Override
    @Transactional
    public void updateUser(UserRequestDto newUser, Long id) {
        User user = getUserById(id);
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setRole(newUser.getRole());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        checkid(id);
        return userRepository.findById(id).get();

    }

    @Override
    public UserResponseDto getUserDtoById(Long id) {
        return userMapper.toResponseDto(getUserById(id));
    }

    @Override
    public void checkid(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException(String.format("Пользователь с таким id = %d не существует", id));
        }
    }
}
