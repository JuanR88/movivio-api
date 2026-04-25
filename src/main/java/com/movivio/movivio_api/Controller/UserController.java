package com.movivio.movivio_api.Controller;

import com.movivio.movivio_api.Model.User;
import com.movivio.movivio_api.Service.UserService;
import com.movivio.movivio_api.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userServive){
        this.userService=userServive;
    }

    @PostMapping("/users")
    public ResponseEntity<String> guardarUsuario(@RequestBody User user){
        userService.guardarUsuario(user);return ResponseEntity.status(HttpStatus.CREATED).body("Usuario guardado");
    }

    @GetMapping("/users")
    public List<UserResponse>obtenerUsuarios()
    {return userService.obtenerUsuarios();}

    @GetMapping("/users/{id}")
    public UserResponse inpeccionarUsuario(@PathVariable Long id) { return userService.inspeccionarUsuario(id);}
}
