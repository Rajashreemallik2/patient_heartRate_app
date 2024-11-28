package com.example.medApp.service;

import com.example.medApp.exception.ResourceNotFoundException;
import com.example.medApp.models.User;
import com.example.medApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid credentials"));
    }
}
