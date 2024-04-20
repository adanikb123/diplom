package com.practice.diplom.mapper;

import com.practice.diplom.dto.UserRequestDto;
import com.practice.diplom.dto.UserResponseDto;
import com.practice.diplom.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GeneralMapper<UserResponseDto, User, UserRequestDto> {
}
