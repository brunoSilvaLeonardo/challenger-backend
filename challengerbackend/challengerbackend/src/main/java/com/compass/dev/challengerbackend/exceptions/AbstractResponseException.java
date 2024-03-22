package com.compass.dev.challengerbackend.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
public abstract class AbstractResponseException extends RuntimeException {

    @Getter
    private final LocalDateTime timestamp = LocalDateTime.now();

    protected AbstractResponseException(String message) {
        super(message);
    }

    public abstract HttpStatus getCode();

    public Set<String> getDetails() {
        return Set.of(getMessage());
    }
}