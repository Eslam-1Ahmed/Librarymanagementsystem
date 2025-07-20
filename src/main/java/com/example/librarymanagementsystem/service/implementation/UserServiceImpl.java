package com.example.librarymanagementsystem.service.implementation;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.DTO.UserDTO;
import com.example.librarymanagementsystem.DTO.UserViewDTO;
import com.example.librarymanagementsystem.entity.SystemUser;
import com.example.librarymanagementsystem.mapper.UserMapper;
import com.example.librarymanagementsystem.repository.SystemUserRepo;
import com.example.librarymanagementsystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final SystemUserRepo systemUserRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(SystemUserRepo systemUserRepo, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.systemUserRepo = systemUserRepo;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String addUser(UserDTO userDTO) {
        if (systemUserRepo.existsByUsername(userDTO.getUsername())) {
            throw new RuntimeException("username already exist");
        }
        systemUserRepo.save(userMapper.toEntity(userDTO));
        return "User added Successfuly";
    }

    @Override
    public String editUser(UserDTO userDTO) {
        SystemUser user = systemUserRepo
                .findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (userDTO.getRole() != null) {
            user.setRole(userDTO.getRole());
        }
        if (userDTO.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        systemUserRepo.save(user);
        return "User Edited Successfuly";
    }

    @Override
    public String deleteUser(Long userId) {
        if (!systemUserRepo.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        systemUserRepo.deleteById(userId);
        return "Deleted Successfuly";
    }

    @Override
    public List<UserViewDTO> getAllUsers() {
        return systemUserRepo.getAllUsers();
    }

}
