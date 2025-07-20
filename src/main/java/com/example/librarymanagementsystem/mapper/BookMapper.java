package com.example.librarymanagementsystem.mapper;

import com.example.librarymanagementsystem.DTO.BookViewDTO;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.librarymanagementsystem.DTO.BookEditDTO;
import com.example.librarymanagementsystem.DTO.BookRequestDTO;
import com.example.librarymanagementsystem.entity.Book;

@Component
public class BookMapper {
        private final AuthorMapper authorMapper;
        private final CategoryMapper categoryMapper;
        private final PublisherMapper publisherMapper;

        public BookMapper(AuthorMapper authorMapper, CategoryMapper categoryMapper, PublisherMapper publisherMapper) {
                this.authorMapper = authorMapper;
                this.categoryMapper = categoryMapper;
                this.publisherMapper = publisherMapper;
        }

        public Book toEntity(BookRequestDTO bookDTO) {
                return Book.builder().ISBN(bookDTO.getISBN()).publicationYear(bookDTO.getPublicationYear())
                                .coverImageUrl(bookDTO.getCoverImageUrl()).edtion(bookDTO.getEdtion())
                                .isBorrowed(false).language(bookDTO.getLanguage())
                                .summary(bookDTO.getSummary())
                                .build();
        }

        public BookViewDTO toBookResponseDTO(Book book) {
                return BookViewDTO.builder()
                                .id(book.getId())
                                .ISBN(book.getISBN())
                                .publicationYear(book.getPublicationYear())
                                .coverImageUrl(book.getCoverImageUrl())
                                .edtion(book.getEdtion())
                                .isBorrowed(book.isBorrowed())
                                .language(book.getLanguage())
                                .summary(book.getSummary())
                                .publisher(publisherMapper.toPublisherViewDTO(book.getPublisher()))
                                .bookAuthors(book.getBookAuthors().stream()
                                                .map(bookAuthor -> authorMapper.toDTO(bookAuthor.getAuthor()))
                                                .collect(Collectors.toList()))
                                .bookCategories(book.getBookCategories().stream()
                                                .map(bookCategory -> categoryMapper.toCateogoryVeiwDTO(bookCategory.getCategory()))
                                                .collect(Collectors.toList()))
                                .build();
        }

        public Book toEntity(BookEditDTO bookEditDTO, Book book) {
                book.setISBN(bookEditDTO.getISBN());
                book.setPublicationYear(bookEditDTO.getPublicationYear());
                book.setCoverImageUrl(bookEditDTO.getCoverImageUrl());
                book.setEdtion(bookEditDTO.getEdtion());
                book.setLanguage(bookEditDTO.getLanguage());
                book.setSummary(bookEditDTO.getSummary());
                return book;
        }
}
