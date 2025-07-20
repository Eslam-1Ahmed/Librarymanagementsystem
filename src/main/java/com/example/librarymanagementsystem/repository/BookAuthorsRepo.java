package com.example.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymanagementsystem.entity.BookAuthors;
@Repository
public interface BookAuthorsRepo extends JpaRepository<BookAuthors,Long> {
    
}
