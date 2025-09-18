package com.authuser.auth_project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authuser.auth_project.Config.JwtUtil;
import com.authuser.auth_project.Models.UserModel;
import com.authuser.auth_project.Repository.AuthRepo;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthRepo authRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map login(@RequestBody UserModel newUser) {

         UserModel user = authRepo.findByEmail(newUser.getEmail());

        if (user != null) {
            if (passwordEncoder.matches(newUser.getPassword(), user.getPassword())) {
                HashMap UserData = new HashMap();
                UserData.put("token", jwtUtil.generateToken(user.getEmail()));
                UserData.put("user", user);
                return UserData;
            }
        }

        return null;
    }
    @PostMapping("/register")
    public Map register(@RequestBody UserModel newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        HashMap UserData = new HashMap();

        UserData.put("token", jwtUtil.generateToken(newUser.getEmail()));

        UserData.put("user",  authRepo.save(newUser));
        return UserData;
    }


    
}
