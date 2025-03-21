package com.example.UserRegister.application.service;


import com.example.UserRegister.domain.entity.User;

public interface UserService {
    User createUser(User user);
}