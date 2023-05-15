package com.example.notes.services;

import com.example.notes.models.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.notes.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    private PasswordEncoder passwordEncoder;

    public String createUser(UserModel user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        usersRepository.save(user);
        return "User created";
    }

    public String login(UserModel user){

        UserModel found = usersRepository.findUserByEmail(user.getEmail());

        if(found != null){
            String password = user.getPassword();
            String encodedPassword = found.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if(isPwdRight){
                Optional <UserModel> another = usersRepository.findUserByEmailAndPassword(user.getEmail(), encodedPassword);
                if(another.isPresent()){
                    return "Login success";
                }else{
                    return "Login failed";
                }
            }else{
                return "Login failed";
            }
        }

        return null;
    }

    public List<UserModel> getAllUsers(){
        return usersRepository.findAll();
    }

    public UserModel getUser(Long id){
        return usersRepository.findById(id).get();
    }
}
