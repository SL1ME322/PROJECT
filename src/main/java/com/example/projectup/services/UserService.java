package com.example.projectup.services;


import com.example.projectup.models.UserModel;
import com.example.projectup.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserModel getUserByLogin(String login){
        UserModel user = userRepository.findByLogin(login);
        return user;
    }
    public UserModel createUser(UserModel user){
        UserModel newUser = userRepository.save(user);
        userRepository.flush();
        return newUser;
    }
}
