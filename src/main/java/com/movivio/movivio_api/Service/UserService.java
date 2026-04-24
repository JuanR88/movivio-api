package com.movivio.movivio_api.Service;

import com.movivio.movivio_api.Model.User;
import com.movivio.movivio_api.Repository.UserRepository;
import com.movivio.movivio_api.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public void guardarUsuario(User user){
        user.setCreatedAt(LocalDateTime.now());
        /**if (user.getUsername()==null || user.getUsername().isEmpty()|| user.getUsername().length() <= 4){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Insertar usuario mayor de 4 caracteres");
        }*/
        /**if (user.getEmail()==null || !user.getEmail().contains("@")|| !user.getEmail().contains(".")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Insertar email");
        }
        if (user.getPassword()==null || user.getPassword().length() < 5 || (!user.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d).+$"))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "La password tiene que tener numeros letras y minimo 5 caracteres");
        }*/
        userRepository.save(user);
    }

    public List<UserResponse> obtenerUsuarios(){
        List<User> users = userRepository.findAll();
        List<UserResponse> listaUsuarios = new ArrayList<>();
        for(int i= 0; i< users.size();i++){
            UserResponse contenedorUserResponse= new UserResponse();
            User paraLeer = users.get(i);
            contenedorUserResponse.setUsername(paraLeer.getUsername());
            contenedorUserResponse.setUserId(paraLeer.getId());
            contenedorUserResponse.setCreatedAt(paraLeer.getCreatedAt());
            listaUsuarios.add(contenedorUserResponse);
        }
        listaUsuarios.sort(new Comparator<UserResponse>() {
            @Override
            public int compare(UserResponse o1, UserResponse o2) {
                return o2.getCreatedAt().compareTo(o1.getCreatedAt());
            }
        });
        return listaUsuarios;
    }

    public  UserResponse inspeccionarUsuario(Long userId){
        User user= userRepository.findById(userId).orElse(null);
        UserResponse userResponse = new UserResponse();
        if (user==null){
            return null ;
        }
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUserId(user.getId());
        userResponse.setUsername(user.getUsername());
        return userResponse;

    }
}