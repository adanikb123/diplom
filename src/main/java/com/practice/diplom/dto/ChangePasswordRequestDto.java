package com.practice.diplom.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequestDto {
    @NotBlank(message = "{password.notBlank}")
    @Size(min = 5,max = 60,message = "{password.wrongSize}")
    private String password;
}
