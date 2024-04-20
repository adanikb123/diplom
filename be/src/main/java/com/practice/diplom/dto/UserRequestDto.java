package com.practice.diplom.dto;

import com.practice.diplom.entity.enums.RoleType;
import com.practice.diplom.validator.RoleTypePattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "{userName.notBlank}")
    @Size(min = 1,max = 50,message = "{userName.wrongSize}")
    private String name;
    @NotBlank(message = "{email.notBlank}")
    @Size(min = 5,max = 50,message = "{email.wrongSize}")
    @Email(message = "{email.invalid}")
    private String email;
    @NotBlank(message = "{password.notBlank}")
    @Size(min = 5,max = 60,message = "{password.wrongSize}")
    private String password;

    @RoleTypePattern(regexp = "USER|ADMIN")
    private RoleType role ;
}
