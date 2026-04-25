package com.movivio.movivio_api.Service;

import com.movivio.movivio_api.Model.Content;
import com.movivio.movivio_api.Model.Review;
import com.movivio.movivio_api.Model.User;
import com.movivio.movivio_api.Repository.ContentRepository;
import com.movivio.movivio_api.Repository.ReviewRepository;
import com.movivio.movivio_api.Repository.UserRepository;
import com.movivio.movivio_api.dto.ReviewUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ReviewService {
    public final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ContentRepository contentRepository;

    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, ContentRepository contentRepository){
        this.reviewRepository=reviewRepository;
        this.userRepository=userRepository;
        this.contentRepository=contentRepository;
    }

    // Cambio la firma del metodo, de public String a....
    public void guardarReview (ReviewUserResponse reviewUserResponse){
        //Buscamos en reviewRequest el UserId
        User user = userRepository.findById(reviewUserResponse.getUserId()).orElse(null);
        //Buscamos en reviewRequest el ContentId
        //Cojo el id- voy a la bd-me traigo la peli

        Content content = contentRepository.findById(reviewUserResponse.getContentId()).orElse(null);
        if (user==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrado");
        }
        if(content==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Contenido no encontrado");
        }
        if (reviewUserResponse.getRating() < 1 || reviewUserResponse.getRating() > 5) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Rating debe de estar entre 1 y 5");}
        Review review= new Review();
        review.setUser(user);
        review.setContent(content);
        review.setRating(reviewUserResponse.getRating());
        review.setComment(reviewUserResponse.getComment());
        review.setCreatedAt(LocalDateTime.now());
        reviewRepository.save(review);
    }

    public List<ReviewUserResponse> reviewByUser(Long userId){
        List<Review>reviews=reviewRepository.findByUserId(userId);
        if(reviews.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }

        List<ReviewUserResponse> listaUsuariosReview =new ArrayList<>();
        for(int i= 0;i<reviews.size();i++){
            ReviewUserResponse contenedorReviewUserResponse = new ReviewUserResponse();
            Review listadoReview = reviews.get(i);
            contenedorReviewUserResponse.setContentId(listadoReview.getContent().getId());
            contenedorReviewUserResponse.setComment(listadoReview.getComment());/**/
            contenedorReviewUserResponse.setRating(listadoReview.getRating());/**/
            contenedorReviewUserResponse.setCreatedAt(listadoReview.getCreatedAt());/**/
            contenedorReviewUserResponse.setUsername(listadoReview.getUser().getUsername());/**/
            contenedorReviewUserResponse.setUserId(listadoReview.getUser().getId());/**/
            contenedorReviewUserResponse.setTitle(listadoReview.getContent().getTitle());/**/
            listaUsuariosReview.add(contenedorReviewUserResponse);
        }
        return listaUsuariosReview;

    }
    public List<ReviewUserResponse> reviewByContent(long contentId){
        // En vez de traernos el objeto entero, nos traemos solo el contentId
        List<Review> reviews =  reviewRepository.findByContentId(contentId);
        if(reviews.isEmpty())
        {throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Comentario no encontrado");
        }
        reviews.sort(new Comparator<Review>() {
            @Override
            public int compare(Review o1, Review o2) {
                return o2.getCreatedAt().compareTo(o1.getCreatedAt());
            }
        });
        List<ReviewUserResponse>listaPelicularReview= new ArrayList<>();
        for (int i = 0; i< reviews.size();i++){
            ReviewUserResponse contenedorReviewUserResponse=new ReviewUserResponse();
            Review listadoReview= reviews.get(i);
            contenedorReviewUserResponse.setContentId(listadoReview.getContent().getId());
            contenedorReviewUserResponse.setTitle(listadoReview.getContent().getTitle());
            contenedorReviewUserResponse.setUsername(listadoReview.getUser().getUsername());
            contenedorReviewUserResponse.setUserId(listadoReview.getUser().getId());
            contenedorReviewUserResponse.setRating(listadoReview.getRating());
            contenedorReviewUserResponse.setComment(listadoReview.getComment());
            contenedorReviewUserResponse.setCreatedAt(listadoReview.getCreatedAt());
            listaPelicularReview.add(contenedorReviewUserResponse);
        }

        return listaPelicularReview;
    }
}
