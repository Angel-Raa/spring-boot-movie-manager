package com.github.angel.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(GlobalDefaultException.class)
    public ResponseEntity<Map<String, Object>> globalDefaultException(GlobalDefaultException exception){
        return ResponseEntity.badRequest().body(Map.of("Message", exception.getMessage()));
    }
}
