package com.example.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymanagementsystem.entity.Author;
@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {
    
}
