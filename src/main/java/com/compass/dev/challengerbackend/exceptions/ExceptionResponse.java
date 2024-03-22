package com.compass.dev.challengerbackend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

    private String code;
    private String message;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
    private Set<String> details;


    public ExceptionResponse(ExceptionCustom ex) {
        this.code = String.valueOf(ex.getCode().value());
        this.message = ex.getMessage();
        //this.details = ex.getDetails();
        //this.timestamp = ex.getTimestamp();
    }

}

