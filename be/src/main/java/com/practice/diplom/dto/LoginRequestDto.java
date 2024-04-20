package com.practice.diplom.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    @NotBlank(message = "{email.notBlank}")
    @Size(min = 5, max = 50, message = "{email.wrongSize}")
    private String email;

    @NotBlank(message = "{password.notBlank}")
    @Size(min = 6, message = "{password.wrongSize}")
    private String password;
}

