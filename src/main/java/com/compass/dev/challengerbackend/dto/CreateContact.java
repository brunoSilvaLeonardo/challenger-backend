package com.compass.dev.challengerbackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class CreateContact {

    private String nome;

    @Email(flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;
    private String message;
    private String interest;


}
