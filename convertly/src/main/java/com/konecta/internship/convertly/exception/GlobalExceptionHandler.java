package com.konecta.internship.convertly.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidUnitException.class)
    public ResponseEntity<String> handleInvalidUnitException(InvalidUnitException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
