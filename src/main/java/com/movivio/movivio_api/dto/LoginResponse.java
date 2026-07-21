package com.movivio.movivio_api.dto;

public class LoginResponse {
    //Atributos
    private String token;
    private String type;

    //Constructor

    public LoginResponse(String token, String type){
        this.token=token;
        this.type=type;
    }

    //Get
    public String getToken(){return token;}

    public String getType(){ return type;}
}
