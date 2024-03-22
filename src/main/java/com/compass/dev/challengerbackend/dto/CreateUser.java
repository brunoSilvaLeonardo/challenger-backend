package com.compass.dev.challengerbackend.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser {

    @JsonAlias(value = "userid")
    private String userId;
    private String password;
    @JsonAlias(value = "fullname")
    private String fullName;
    @JsonAlias(value = "birthdate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;

}
