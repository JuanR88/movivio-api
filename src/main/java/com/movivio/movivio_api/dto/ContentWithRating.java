package com.movivio.movivio_api.dto;

import com.movivio.movivio_api.Model.Content;

public class ContentWithRating {
    private Content content;
    private double media;

    public ContentWithRating(){}

    public Content getContent(){
        return content;
    }
    public double getMedia(){
        return media;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
