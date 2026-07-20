package com.movivio.movivio_api.Repository;

import com.movivio.movivio_api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // Busca un usuario por email único.
    // Si existe lo devuelve, si no devuelve null.
    User findByEmail(String email);
}