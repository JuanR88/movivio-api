package com.movivio.movivio_api.Service;

import com.movivio.movivio_api.Repository.ReviewRepository;
import com.movivio.movivio_api.dto.ContentWithRating;
import com.movivio.movivio_api.Model.Content;
import com.movivio.movivio_api.Model.Review;
import com.movivio.movivio_api.Repository.ContentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ContentService {
    private final ContentRepository contentRepository;
    private final ReviewRepository reviewRepository;

    public ContentService (ContentRepository contentRepository, ReviewRepository reviewRepository){
        this.contentRepository=contentRepository;
        this.reviewRepository=reviewRepository;
    }

    /**
     *Cuardo content
     */
    public String guardarContent(Content content){
        content.setCreatedAt(LocalDateTime.now());
        contentRepository.save(content);
        return "Content guardado";
    }

     /**
     * Muestro todas las pelis y series
     */

    public List<Content> mostrarContent(){return contentRepository.findAll();}

    /**
     *Detalles de un content
     */

    public Content detallesContent (Long contentId){
        return contentRepository.findById(contentId).orElse(null);
    }

    /**
     * Media Rating content
     * */
    public double mediaRating(Long contentId){
        Content content=contentRepository.findById(contentId).orElse(null);
        List<Review> reviews=reviewRepository.findByContent(content);
        if (reviews.isEmpty()){
            return 0;
        }
        int sumaReviews=0;
        for (int i=0; i<reviews.size();i++){
             sumaReviews+=reviews.get(i).getRating();
        }
        return (double) sumaReviews/reviews.size();
    }

    /**
     * Top Content
     * */
    public List<ContentWithRating> topContent(){
        List<Content> contents = contentRepository.findAll();
        List<ContentWithRating> resultados = new ArrayList<>();
            for (int i=0;i<contents.size();i++){
            ContentWithRating contenedorContentWithRatin= new ContentWithRating();
            Content contentSacado = contents.get(i);
            double media = mediaRating(contentSacado.getId());
            contenedorContentWithRatin.setContent(contentSacado);
            contenedorContentWithRatin.setMedia(media);
            resultados.add(contenedorContentWithRatin);

        }
        resultados.sort(new Comparator<ContentWithRating>() {
            @Override
            public int compare(ContentWithRating r1, ContentWithRating r2) {
                return Double.compare(r2.getMedia(), r1.getMedia());
            }
        });
            return resultados;
    }



}