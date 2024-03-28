package com.practice.diplom.service;

import com.practice.diplom.dto.UserSongRequestDto;
import com.practice.diplom.dto.UserSongResponseDto;
import com.practice.diplom.entity.UserSong;
import com.practice.diplom.mapper.UserSongMapper;

import java.util.List;

public interface UserSongService {

    List<UserSongResponseDto> getAllUserSongsByUserId(Long id);

    UserSongResponseDto createUserSong(UserSongRequestDto userSongRequestDto);


    void checkId(Long id);
}
