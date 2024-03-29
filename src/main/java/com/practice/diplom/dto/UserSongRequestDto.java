package com.practice.diplom.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSongRequestDto {
    @NotBlank(message = "{songId.notBlank}")
    private Long songId;
    @NotBlank(message = "{userId.notBlank}")
    private Long userId;
}
