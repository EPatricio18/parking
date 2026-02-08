package com.statementlabs.parking_api.presentation.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllErrors(Exception e) {
        e.printStackTrace();
        return ResponseEntity.internalServerError().body("ERRO REVELADO: " + e.getMessage());
    }
}