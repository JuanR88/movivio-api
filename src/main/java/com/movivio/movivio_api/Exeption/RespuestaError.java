package com.movivio.movivio_api.Exeption;

public class RespuestaError {
    private int status;
    private String error;
    private String message;

    public RespuestaError (int status ,String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }
        public int getStatus(){
            return status;
        }
        public String getError(){
            return error;
        }
        public String getMessage(){
            return message;
        }


}
