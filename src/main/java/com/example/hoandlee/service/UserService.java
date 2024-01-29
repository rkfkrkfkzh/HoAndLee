package com.example.hoandlee.service;

import com.example.hoandlee.domain.User;
import com.example.hoandlee.repository.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public boolean registerUser(User user) {
        User existing = userMapper.findByUsername(user.getUsername());
        if (existing != null) {
            return false; // User already exists
        }
        user.setPassword(user.getPassword());
        userMapper.save(user);
        return true;
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }


}
