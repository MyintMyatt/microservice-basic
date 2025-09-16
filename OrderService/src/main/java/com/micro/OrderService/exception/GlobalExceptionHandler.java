package com.micro.OrderService.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex) {
        System.err.println("call custom excep");
        return ResponseEntity.status(ex.getErrorCode()).body(Map.of("message", ex.getMessage(), "status", ex.getErrorStatus(), "error_code", ex.getErrorCode()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception e) {
        return ResponseEntity.status(500).body(Map.of("error", e.getMessage(), "class", e.getClass()));
    }


}
