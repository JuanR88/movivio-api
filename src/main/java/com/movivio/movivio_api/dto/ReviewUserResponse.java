package com.movivio.movivio_api.dto;


import java.time.LocalDateTime;

public class ReviewUserResponse {

    private Long userId;
    private Long contentId;
    private String username;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;
    private String title;

    public ReviewUserResponse(){}

    //get
    public Long getContentId(){return contentId;}
    public Long getUserId(){ return userId;}
    public String getUsername(){ return username;}
    public int getRating(){ return rating;}
    public String getComment(){return comment;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public String getTitle(){return title;}

    //set

    public void setContentId(Long contentId) {this.contentId = contentId;}
    public void setUserId(Long userId){this.userId = userId;}
    public void setUsername(String username){this.username = username;}
    public void setRating(int rating){this.rating=rating;}
    public void setComment(String comment){this.comment=comment;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
    public void setTitle(String title){this.title= title;}

}
