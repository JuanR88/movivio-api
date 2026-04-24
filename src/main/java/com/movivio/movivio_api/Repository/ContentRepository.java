package com.movivio.movivio_api.Repository;

import com.movivio.movivio_api.Model.Content;
import com.movivio.movivio_api.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {

    }