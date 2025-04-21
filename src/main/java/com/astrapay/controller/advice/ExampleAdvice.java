package com.astrapay.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.astrapay.exception.NotFoundException;

@ControllerAdvice
class ExampleAdvice {
    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(Exception.class)
    public void handleConflict() {
        // Nothing to do
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFound(NotFoundException ex) {
       
    
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}