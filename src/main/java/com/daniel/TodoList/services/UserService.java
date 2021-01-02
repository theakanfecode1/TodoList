package com.daniel.TodoList.services;

import com.daniel.TodoList.models.User;
import com.daniel.TodoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User registerUser(User user){
        return userRepository.save(user);
    }

    public Boolean existsByUsername(String name){
        return userRepository.existsByUsername(name);
    }

    public Boolean existsByEmail(String name){
        return userRepository.existsByEmail(name);
    }


}
