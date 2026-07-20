package com.movivio.movivio_api.dto;

public class LoginRequest {
        //ATRIBUTOS
    private String email;
    private String password;
        //CONSTRUCTOR

    public LoginRequest(){}
        //GET

        public String getEmail() {
            return email;
        }
        public String getPassword(){
            return password;
        }

        //SET

        public void setEmail(String email){
            this.email= email;
        }
        public void setPassword(String password){
            this.password= password;
        }
    }

