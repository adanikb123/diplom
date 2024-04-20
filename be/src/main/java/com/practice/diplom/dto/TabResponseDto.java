package com.practice.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TabResponseDto {
    private Long id;
    private String instrumentName;
    private String url;

}
