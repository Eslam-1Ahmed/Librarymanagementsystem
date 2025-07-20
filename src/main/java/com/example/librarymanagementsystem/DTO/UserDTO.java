package com.example.librarymanagementsystem.DTO;

import com.example.librarymanagementsystem.enums.Role;

import lombok.Data;

@Data
public class UserDTO {

    private String username;

    private String password;

    private Role role;
}
