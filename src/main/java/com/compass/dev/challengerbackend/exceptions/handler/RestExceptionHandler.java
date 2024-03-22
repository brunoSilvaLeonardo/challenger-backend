package com.compass.dev.challengerbackend.exceptions.handler;


import com.compass.dev.challengerbackend.exceptions.ExceptionCustom;
import com.compass.dev.challengerbackend.exceptions.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler { //extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ExceptionCustom.class)
    public ResponseEntity<ExceptionResponse> handleUserExceptions(ExceptionCustom ex) {
        return ResponseEntity.status(ex.getCode()).body(new ExceptionResponse(ex));
    }
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ExceptionResponse> handleBindException(
            BindException ex) {

        log.error("RestExceptionHandler.handleBindException - An unexpected error occur", ex);
        var fieldErrors = ex.getBindingResult().getFieldErrors();
        var errors = fieldErrors.stream().map(
                        f -> removeIndexFromPropertyPath(f.getField(), getErrorMessage(ex, f)))
                .collect(Collectors.toSet());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ExceptionResponse.builder()
                        .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                        .details(errors).build());
    }

    private String removeIndexFromPropertyPath(String propertyPath, String message) {
        String field = propertyPath.replaceAll("(\\[\\d])+", "");
        return "%s : %s".formatted(field, message);
    }

    private String getErrorMessage(BindException ex, FieldError fieldError) {
        var field = fieldError.getField();
        var clazz = ex.getFieldType(field);

        if (isNull(clazz)) {
            return fieldError.getDefaultMessage();
        }

        if (clazz.isEnum()) {
            var rejectedValue = String.valueOf(fieldError.getRejectedValue());
            var values = Arrays
                    .stream(clazz.getEnumConstants())
                    .map(Object::toString)
                    .collect(Collectors.toSet());
            return "%s is not a valid value, allowed options: %s".formatted(rejectedValue, values);
        }

        return fieldError.getDefaultMessage();
    }

    /*@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        request.getDescription(false);
        var ise = new InternalServerErrorException(ex);
        return ResponseEntity.status(ise.getCode()).body(new ExceptionResponse(ise));
    }*/
}