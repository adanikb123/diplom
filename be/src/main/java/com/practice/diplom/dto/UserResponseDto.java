package com.practice.diplom.dto;

import com.practice.diplom.entity.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long id;

    private String name;

    private String email;

    private RoleType role;
}
