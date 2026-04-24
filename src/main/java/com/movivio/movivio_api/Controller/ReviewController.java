package com.movivio.movivio_api.Controller;


import com.movivio.movivio_api.Service.ReviewService;
import com.movivio.movivio_api.dto.ReviewUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService=reviewService;
    }

    @GetMapping("/hola/review")
    public String compruebor(){return "hola que tal desde review";}

    //Guardar review
    @PostMapping("/review")
    public ResponseEntity<String> guardarReview(@RequestBody ReviewUserResponse reviewUserResponse){
        reviewService.guardarReview(reviewUserResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body("Guardado");
    }

    @GetMapping("/users/{id}/reviews")
    public ResponseEntity<List<ReviewUserResponse>> reviewsUsuarios(@PathVariable Long id){
        List<ReviewUserResponse>reviews=reviewService.reviewByUser(id);
        return ResponseEntity.ok(reviews);

    }

    @GetMapping("/content/{id}/reviews")
    public ResponseEntity<List<ReviewUserResponse>> reviewsPelis(@PathVariable Long id){
        List<ReviewUserResponse>reviews=reviewService.reviewByContent(id);
          return ResponseEntity.ok(reviews);
    }
}

