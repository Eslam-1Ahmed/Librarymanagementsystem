package com.example.librarymanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.librarymanagementsystem.DTO.UserViewDTO;
import com.example.librarymanagementsystem.entity.SystemUser;

@Repository
public interface SystemUserRepo extends JpaRepository<SystemUser, Long> {

    Optional<SystemUser> findByUsername(String username);

    boolean existsByUsername(String username);

    @Query("select new com.example.librarymanagementsystem.DTO.UserViewDTO(u.username,u.role) from SystemUser u")
    List<UserViewDTO> getAllUsers();
}
