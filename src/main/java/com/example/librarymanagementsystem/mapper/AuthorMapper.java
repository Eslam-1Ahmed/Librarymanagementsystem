package com.example.librarymanagementsystem.mapper;

import org.springframework.stereotype.Component;

import com.example.librarymanagementsystem.DTO.AuthorDTO;
import com.example.librarymanagementsystem.entity.Author;

@Component
public class AuthorMapper {
    public AuthorDTO toDTO(Author author) {
        return AuthorDTO.builder().id(author.getId()).bio(author.getBio()).name(author.getName())
                .dateOfBirth(author.getDateOfBirth()).build();
    }

    public Author toEntity(AuthorDTO author) {
        return Author.builder().id(author.getId()).bio(author.getBio()).name(author.getName())
                .dateOfBirth(author.getDateOfBirth()).build();
    }

    public void updateFromDTO(AuthorDTO authorDTO, Author author) {
        author.setBio(authorDTO.getBio());
        author.setDateOfBirth(authorDTO.getDateOfBirth());
        author.setName(author.getName());
    }
}
