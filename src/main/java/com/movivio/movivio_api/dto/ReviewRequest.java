package com.movivio.movivio_api.dto;

public class ReviewRequest {
    //ATRIBUTOS
    private Long userId;
    private Long contentId;
    private int rating;
    private String comment;
    //CONSTRUCTOR
    public ReviewRequest(){}

    //Get
    public Long getUserId() {return userId;}
    public Long getContentId(){return contentId;}
    public int getRating() {
        return rating;
    }
    public String getComment() {
        return comment;
    }

    //Set

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }


}
