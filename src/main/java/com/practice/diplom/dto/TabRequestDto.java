package com.practice.diplom.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TabRequestDto {

    @NotBlank(message = "{instrumentName.notBlank}")
    private String instrumentName;
    @NotBlank(message = "{url.notBlank}")
    @URL(message = "{url.invalid}")
    private String url;

}
