package com.compass.dev.challengerbackend.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends AbstractResponseException {

    public InternalServerErrorException(Exception ex) {
        super(ex.getMessage());
    }

    @Override
    public HttpStatus getCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}