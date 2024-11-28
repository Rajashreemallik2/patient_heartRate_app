package com.example.medApp.controller;

import com.example.medApp.models.User;
import com.example.medApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody @Valid User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> credentials) {
        return userService.login(credentials.get("email"), credentials.get("password"));
    }
}
