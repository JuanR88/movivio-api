package com.movivio.movivio_api.Exeption;

public class UsuarioYaExisteException extends RuntimeException {
    public UsuarioYaExisteException(String mensaje){
        super(mensaje);
    }
}
