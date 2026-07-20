package com.movivio.movivio_api.Exeption;

public class CredencialesIncorrectasException extends  RuntimeException{
    public CredencialesIncorrectasException(String mensaje){
        super(mensaje);
    }
}
