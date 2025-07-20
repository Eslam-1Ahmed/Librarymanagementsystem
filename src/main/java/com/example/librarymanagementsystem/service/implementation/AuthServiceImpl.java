package com.example.librarymanagementsystem.service.implementation;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.DTO.LoginDTO;
import com.example.librarymanagementsystem.entity.SystemUser;
import com.example.librarymanagementsystem.security.jwt.JwtService;
import com.example.librarymanagementsystem.security.user.CustomUserDetailsService;
import com.example.librarymanagementsystem.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtService jwtService,
            CustomUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;

    }

    @Override
    public String login(LoginDTO loginDTO) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()));
        SystemUser user = userDetailsService.loadUserByUsername(loginDTO.getUsername());
        return jwtService.generateToken(user);
    }

}
