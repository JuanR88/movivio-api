package com.movivio.movivio_api.Model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private int rating;
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private String comment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;

    public Review(){}

    //GET

    public User getUser() {
        return user;
    }

    public Content getContent() {
        return content;
    }
    public Long getId() {
        return id;
    }
    public int getRating() {
        return rating;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public String getComment(){
        return comment;
    }

    //SET


    public void setContent(Content content) {
        this.content = content;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setRating(int ranting) {
        this.rating = ranting;
    }
    public void setComment(String comment){
        this.comment=comment;
    }
}
