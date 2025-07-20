package com.example.librarymanagementsystem.service;

import org.springframework.data.domain.Page;

import com.example.librarymanagementsystem.DTO.AuthorDTO;

public interface AuthorService {
    public String addAuthor(AuthorDTO authorDTO);

    public String editAuthor(AuthorDTO authorDTO);

    public String deleteAuthor(Long id);

    public Page<AuthorDTO> getAllAuthors(int page, int size);

    public AuthorDTO getAuthor(Long id);
}
