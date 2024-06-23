package com.example.onlinestore.controller;

import com.example.onlinestore.Entity.User;
import com.example.onlinestore.dto.UserDTO;
import com.example.onlinestore.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @Operation(description = "Получение всех пользователей")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }







}
