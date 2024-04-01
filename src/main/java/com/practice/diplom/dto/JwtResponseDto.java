package com.practice.diplom.dto;

import com.practice.diplom.entity.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDto {

    private String token;

    private String type = "Bearer";

    private Long id;

    private String username;

    private String email;

    private RoleType role;
}