package com.practice.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongRequestDto {
    private String author;

    private String name;

    private List<TabRequestDto> tabs;
}
