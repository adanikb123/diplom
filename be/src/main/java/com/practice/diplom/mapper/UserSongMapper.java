package com.practice.diplom.mapper;

import com.practice.diplom.dto.UserSongRequestDto;
import com.practice.diplom.dto.UserSongResponseDto;
import com.practice.diplom.entity.UserSong;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserSongMapper extends GeneralMapper<UserSongResponseDto, UserSong, UserSongRequestDto>{
}
