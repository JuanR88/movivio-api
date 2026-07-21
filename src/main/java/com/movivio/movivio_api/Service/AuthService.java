package com.movivio.movivio_api.Service;

import com.movivio.movivio_api.Exeption.CredencialesIncorrectasException;
import com.movivio.movivio_api.dto.LoginRequest;
import com.movivio.movivio_api.Exeption.UsuarioYaExisteException;
import com.movivio.movivio_api.Model.User;
import com.movivio.movivio_api.Repository.UserRepository;
import com.movivio.movivio_api.dto.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService)
    {this.userRepository=userRepository;
    this.passwordEncoder=passwordEncoder;
    this.jwtService =jwtService;
    }

    public void guardarRegistro(RegisterRequest request){
       User user = userRepository.findByEmail(request.getEmail()); //Buscar usuario por email
       if (user != null ) {
           throw new UsuarioYaExisteException(
                   "Ya existe una cuenta con ese email"
           );
       }
           User userNew  = new User();
           userNew.setUsername(request.getUsername());
           userNew.setEmail(request.getEmail());
           userNew.setPassword( passwordEncoder.encode (request.getPassword()));
           userNew.setCreatedAt(LocalDateTime.now());
           userRepository.save(userNew);
    }
    public String login (LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null){
            throw new CredencialesIncorrectasException(
                    "Usuario o contraseña incorrecta"
            );

        }
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {

            throw new CredencialesIncorrectasException(
                    "Usuario o contraseña incorrecta"
            );
        }
        return jwtService.generarToken(user.getEmail());
    }
}
