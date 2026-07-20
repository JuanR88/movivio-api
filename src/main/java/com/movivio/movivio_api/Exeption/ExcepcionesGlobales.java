package com.movivio.movivio_api.Exeption;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice

public class ExcepcionesGlobales {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String>errorEmailIncorrecto(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ya hay una cuenta con este Email ");
    }
    @ExceptionHandler(UsuarioYaExisteException.class)
    public ResponseEntity<RespuestaError> usuarioYaExiste(
            UsuarioYaExisteException ex){
        RespuestaError respuesta = new RespuestaError(
                409,"Conflict", ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
    }
    @ExceptionHandler(CredencialesIncorrectasException.class)
    public ResponseEntity<RespuestaError> loginIncorrecto(
            CredencialesIncorrectasException ex){
        RespuestaError respuesta = new RespuestaError(
                401, "Unauthorized",ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED) .body(respuesta);
    }
}
