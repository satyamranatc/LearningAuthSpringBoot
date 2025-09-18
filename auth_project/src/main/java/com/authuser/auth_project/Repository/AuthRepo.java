package com.authuser.auth_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authuser.auth_project.Models.UserModel;

public interface AuthRepo extends JpaRepository<UserModel, Long> {

    UserModel findByEmail(String email);

    
}
