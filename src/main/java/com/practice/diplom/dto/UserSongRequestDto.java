package com.practice.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSongRequestDto {
    private Long id;
    private Long songId;

    private Long userId;
}
