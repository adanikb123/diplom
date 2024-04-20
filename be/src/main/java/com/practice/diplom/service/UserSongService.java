package com.practice.diplom.service;

import com.practice.diplom.dto.UserSongRequestDto;
import com.practice.diplom.dto.UserSongResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserSongService {

    Page<UserSongResponseDto> getAllUserSongsByUserId(Long id, Pageable pageable);

    UserSongResponseDto createUserSong(UserSongRequestDto userSongRequestDto);


}
