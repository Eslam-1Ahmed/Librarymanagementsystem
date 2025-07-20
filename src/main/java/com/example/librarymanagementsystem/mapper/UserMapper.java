package com.example.librarymanagementsystem.mapper;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.librarymanagementsystem.DTO.UserDTO;
import com.example.librarymanagementsystem.entity.SystemUser;

@Component
public class UserMapper {
    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public SystemUser toEntity(UserDTO userDTO) {
        return SystemUser.builder().username(userDTO.getUsername()).role(userDTO.getRole())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .createdAt(LocalDateTime.now()).build();
    }
}
