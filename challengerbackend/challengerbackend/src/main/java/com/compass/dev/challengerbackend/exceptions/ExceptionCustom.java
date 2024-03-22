package com.compass.dev.challengerbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExceptionCustom extends RuntimeException {


    public HttpStatus getCode() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public String getMessage() {
        return "Exceção customizada";
    }

    public List<String> getDetail() {
        return List.of("Exceção customizada");
    }
}
