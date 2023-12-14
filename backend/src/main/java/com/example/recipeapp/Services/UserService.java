package com.example.recipeapp.Services;

import com.example.recipeapp.Model.User;
import com.example.recipeapp.Repositories.UserRepository;
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

    public Optional<User> findUserByUserName(String username) {
        return userRepository.findUserByUserName(username);
    }

    // Add other user-related methods as needed

}