package com.movivio.movivio_api.Repository;

import com.movivio.movivio_api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}