package com.example.librarymanagementsystem.DTO;

import com.example.librarymanagementsystem.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserViewDTO {
    private String username;
    private Role role;
}
