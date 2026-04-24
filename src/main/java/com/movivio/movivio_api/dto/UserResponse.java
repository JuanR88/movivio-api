package com.movivio.movivio_api.dto;

import java.time.LocalDateTime;

public class UserResponse {
    private  Long userId;
    private  String username;
    private  LocalDateTime createdAt;

    public UserResponse(){}

    //get

    public Long getUserId(){return userId;}

    public String getUsername() {
        return username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    //set
    public void setUserId(Long userId){this.userId=userId;}

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
