package com.example.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymanagementsystem.entity.Book;

import java.util.Optional;
@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    public Optional<Book> findByISBN(String ISBN);
}
