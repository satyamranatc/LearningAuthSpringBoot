package com.authuser.auth_project.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserModel {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long id;

    public String fullName;
    public String avatar;
    public String email;
    public String password;

    public UserModel(String fullName, String avatar, String email, String password) {
        this.fullName = fullName;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
    }

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
}
