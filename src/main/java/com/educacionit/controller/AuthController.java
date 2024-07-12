package com.educacionit.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.model.AuthResponse;
import com.educacionit.model.dto.UserDTO;
import com.educacionit.service.AuthService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserDTO request, HttpServletResponse response) {
        try {
            AuthResponse auth = authService.login(request);
            return ResponseEntity.ok(auth);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserDTO request) {
        try {
            AuthResponse auth = authService.register(request);
            return ResponseEntity.ok(auth);
        } catch (Exception e) { 
            return ResponseEntity.internalServerError().build();
        }
    }

}
