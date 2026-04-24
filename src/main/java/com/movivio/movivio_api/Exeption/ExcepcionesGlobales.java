package com.movivio.movivio_api.Exeption;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice

public class ExcepcionesGlobales {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String>errorEmailIncorrecto(DataIntegrityViolationException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ya hay una cuenta con este Email ");
    }
}
