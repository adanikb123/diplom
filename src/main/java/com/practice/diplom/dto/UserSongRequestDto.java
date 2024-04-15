package com.practice.diplom.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSongRequestDto {
    @NotNull(message = "{songId.notNull}")
    private Long songId;
    @NotNull(message = "{userId.notNull}")
    private Long userId;
}
