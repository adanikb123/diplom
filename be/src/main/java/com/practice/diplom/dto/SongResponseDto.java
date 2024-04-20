package com.practice.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongResponseDto {

    private Long id;

    private String author;

    private String name;

    private List<TabResponseDto> tabs;
}
