package com.practice.diplom.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongRequestDto {
    @NotNull(message = "{author.notNull}")
    private String author;
    @NotBlank(message = "{name.notBlank}")
    private String name;

    @NotNull(message = "{tabs.notNull}")
    private List<TabRequestDto> tabs;
}
