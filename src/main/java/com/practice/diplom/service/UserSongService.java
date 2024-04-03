package com.practice.diplom.service;

import com.practice.diplom.dto.UserSongRequestDto;
import com.practice.diplom.dto.UserSongResponseDto;
import com.practice.diplom.entity.UserSong;
import com.practice.diplom.mapper.UserSongMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserSongService {

    Page<UserSongResponseDto> getAllUserSongsByUserId(Long id, Pageable pageable);

    UserSongResponseDto createUserSong(UserSongRequestDto userSongRequestDto);


    void checkId(Long id);
}
