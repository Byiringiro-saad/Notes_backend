package com.example.notes.services;

import com.example.notes.models.UserModel;
import org.springframework.stereotype.Service;
import com.example.notes.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public String createUser(UserModel user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        usersRepository.save(user);
        return "User created";
    }

    public String login(UserModel user){
        UserModel found = usersRepository.findUserByEmail(user.getEmail());
        return null;
    }

    public List<UserModel> getAllUsers(){
        return usersRepository.findAll();
    }

    public UserModel getUser(Long id){
        return usersRepository.findById(id).get();
    }
}
