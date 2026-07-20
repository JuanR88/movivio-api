package com.movivio.movivio_api.Service;

import com.movivio.movivio_api.Model.User;
import com.movivio.movivio_api.Repository.UserRepository;
import com.movivio.movivio_api.dto.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {this.userRepository=userRepository;
    this.passwordEncoder=passwordEncoder;
    }

    public void guardarRegistro(RegisterRequest request){
       User user = userRepository.findByEmail(request.getEmail());
       if (user != null ) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ya creado");
       }

           User userNew  = new User();
           userNew.setUsername(request.getUsername());
           userNew.setEmail(request.getEmail());
           userNew.setPassword( passwordEncoder.encode (request.getPassword()));
           userNew.setCreatedAt(LocalDateTime.now());
           userRepository.save(userNew);


    }
}
