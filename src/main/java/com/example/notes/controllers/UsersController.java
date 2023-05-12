package com.example.notes.controllers;

import com.example.notes.models.UserModel;
import com.example.notes.services.UsersService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/users")
    private String createUser(@RequestBody UserModel user){
        usersService.createUser(user);
        return "User created";
    }

    @PostMapping("/login")
    private String login(@RequestBody UserModel user){
        return usersService.login(user);
    }

    @GetMapping("/users")
    private List<UserModel> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    private UserModel getUser(@PathVariable("id") Long id){
        return usersService.getUser(id);
    }
}
