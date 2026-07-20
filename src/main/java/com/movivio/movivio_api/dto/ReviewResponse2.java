package com.movivio.movivio_api.dto;

import java.time.LocalDateTime;

public class ReviewResponse2 {
    private Long userId;
    private String username;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;


    public ReviewResponse2(){}

    //Get


    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    //Set
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void  setUsername(String username){
        this.username=username;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
