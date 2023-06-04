package com.example.foodDelivery_server.controller;

import com.example.foodDelivery_server.Exeptions.isUserExistExeption;
import com.example.foodDelivery_server.entity.UserEntity;
import com.example.foodDelivery_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/registration")
    ResponseEntity addUser(@RequestBody UserEntity user){
        try {
            userService.addUser(user);
            System.out.println(user +"REGISTRATION");
            return ResponseEntity.ok("ok");
        }catch (isUserExistExeption e){
            return ResponseEntity.badRequest().body("Пользователь с таким логином уже существует");
        }
    }

    @GetMapping("/getUsers")
    public ResponseEntity getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody UserEntity user){
        return ResponseEntity.ok().body(userService.auth(user.login, user.password));
    }
}
