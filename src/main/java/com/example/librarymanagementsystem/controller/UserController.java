package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.UserDTO;
import com.example.librarymanagementsystem.DTO.UserViewDTO;
import com.example.librarymanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.addUser(userDTO));
    }

    @PutMapping
    public ResponseEntity<String> edit(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.editUser(userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @GetMapping
    public ResponseEntity<List<UserViewDTO>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
