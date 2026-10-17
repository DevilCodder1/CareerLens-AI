package com.careerlens.controller;

import com.careerlens.dto.LoginRequestDTO;
import com.careerlens.entity.User;
import com.careerlens.security.JwtService;
import com.careerlens.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequestDTO request) {

        User user = userService.login(
                request.getEmail(),
                request.getPassword()
        );

        return jwtService.generateToken(user.getEmail());
    }
}