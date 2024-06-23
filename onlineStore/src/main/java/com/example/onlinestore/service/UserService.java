package com.example.onlinestore.service;

import com.example.onlinestore.Entity.User;
import com.example.onlinestore.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService { //security
    ResponseEntity<User> save(UserDTO userDTO);
    List<User> getAllUsers();
}
