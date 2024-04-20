package com.practice.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSongResponseDto {
    private Long id;
    private SongResponseDto song;

    private UserResponseDto user;
}
