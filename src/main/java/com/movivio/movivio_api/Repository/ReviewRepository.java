package com.movivio.movivio_api.Repository;

import com.movivio.movivio_api.Model.Content;
import com.movivio.movivio_api.Model.Review;
import com.movivio.movivio_api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    //Vemos todas las review de un content
    List<Review> findByContent(Content content);

    //Vemos todas las review de un usuario
    List<Review> findByUser(User user);

    // Traemos el Id de content
    List<Review> findByContentId( Long contentId );

    //id usuario
    List<Review> findByUserId (Long userId);
}