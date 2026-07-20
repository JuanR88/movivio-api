package com.movivio.movivio_api.Controller;

import com.movivio.movivio_api.Service.AuthService;
import com.movivio.movivio_api.dto.LoginRequest;
import com.movivio.movivio_api.dto.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController

public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<String>guardarRegistro(@RequestBody RegisterRequest request){
        authService.guardarRegistro(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario guardado");
    }
    @PostMapping("/auth/login")
    public ResponseEntity<String>login(@RequestBody LoginRequest request){
        authService.login(request);
        return ResponseEntity.status(HttpStatus.OK).body("Login completo");
    }


}
