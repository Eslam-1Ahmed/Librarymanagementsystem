package com.example.librarymanagementsystem.service;

import java.util.List;

import com.example.librarymanagementsystem.DTO.UserDTO;
import com.example.librarymanagementsystem.DTO.UserViewDTO;

public interface UserService {
    public String addUser(UserDTO userDTO);

    public String editUser(UserDTO userDTO);

    public String deleteUser(Long userId);

    public List<UserViewDTO> getAllUsers();
}
