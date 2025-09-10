package com.authuser.auth_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authuser.auth_project.Models.UserModel;
import com.authuser.auth_project.Repository.AuthRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthRepo authRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/register")
    public UserModel register(@RequestBody UserModel newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return authRepo.save(newUser);
    }


    
}
