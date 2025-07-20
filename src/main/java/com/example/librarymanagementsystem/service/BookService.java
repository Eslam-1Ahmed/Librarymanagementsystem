package com.example.librarymanagementsystem.service;

import org.springframework.data.domain.Page;

import com.example.librarymanagementsystem.DTO.BookEditDTO;
import com.example.librarymanagementsystem.DTO.BookRequestDTO;
import com.example.librarymanagementsystem.DTO.BookViewDTO;

public interface BookService {
    public String addBook(BookRequestDTO bookDTO);

    public String editBook(BookEditDTO bookDTO);

    public String deleteBook(Long id);

    public BookViewDTO getBook(Long id);

    public Page<BookViewDTO> getAllBooks(int page, int size);

    public BookViewDTO getBook(String ISBN);

}
