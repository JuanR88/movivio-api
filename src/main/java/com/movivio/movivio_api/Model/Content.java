package com.movivio.movivio_api.Model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String description;
    private String type;
    private LocalDate releaseDate;
    private String genre;
    private String posterUrl;
    private LocalDateTime createdAt;

    public Content(){};


    //GET
    public Long getId(){
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getType() {
        return type;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public String getGenre(){
        return genre;
    }
    public String getPosterUrl(){
        return posterUrl;
    }
    public LocalDateTime getCreatedAt(){
    return createdAt;
    }

    //SET
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setReleaseDate(LocalDate releaseDate){
        this.releaseDate = releaseDate;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

}
