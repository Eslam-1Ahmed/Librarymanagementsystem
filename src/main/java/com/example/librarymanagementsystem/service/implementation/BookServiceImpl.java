package com.example.librarymanagementsystem.service.implementation;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.DTO.BookEditDTO;
import com.example.librarymanagementsystem.DTO.BookRequestDTO;
import com.example.librarymanagementsystem.DTO.BookViewDTO;
import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.entity.BookAuthors;
import com.example.librarymanagementsystem.entity.BookCategories;
import com.example.librarymanagementsystem.entity.Category;
import com.example.librarymanagementsystem.entity.Publisher;
import com.example.librarymanagementsystem.mapper.BookMapper;
import com.example.librarymanagementsystem.repository.AuthorRepo;
import com.example.librarymanagementsystem.repository.BookRepo;
import com.example.librarymanagementsystem.repository.CategoryRepo;
import com.example.librarymanagementsystem.repository.PublisherRepo;
import com.example.librarymanagementsystem.service.BookService;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;
    private final PublisherRepo publisherRepo;
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final CategoryRepo categoryRepo;

    public BookServiceImpl(BookMapper bookMapper, PublisherRepo publisherRepo, AuthorRepo authorRepo, BookRepo bookRepo,
            CategoryRepo categoryRepo) {
        this.bookMapper = bookMapper;
        this.publisherRepo = publisherRepo;
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
    }

    @Transactional
    @Override
    public String addBook(BookRequestDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        setBookRelations(book, bookDTO.getPublisherId(), bookDTO.getAuthorIds(), bookDTO.getCategoryIds());
        bookRepo.save(book);
        return "Added Successfuly";
    }

    @Override
    @Transactional
    public String editBook(BookEditDTO bookDTO) {
        Book book = bookRepo.findById(bookDTO.getId()).orElseThrow(
                () -> new RuntimeException("Book not found"));
        bookMapper.toEntity(bookDTO, book);
        setBookRelations(book, bookDTO.getPublisherId(), bookDTO.getAuthorIds(), bookDTO.getCategoryIds());
        bookRepo.save(book);
        return "Edited Successfuly";
    }

    @Override
    public String deleteBook(Long id) {
        if (!bookRepo.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookRepo.deleteById(id);
        return "Deleted Successfuly";
    }

    @Override
    public BookViewDTO getBook(Long id) {
        Book book = bookRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Book not found"));
        BookViewDTO bookDTO = bookMapper.toBookResponseDTO(book);
        return bookDTO;
    }

    @Override
    public Page<BookViewDTO> getAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return bookRepo.findAll(pageable)
                .map(bookMapper::toBookResponseDTO);
    }

    private void setBookRelations(Book book, Long publisherId, List<Long> authorIds, List<Long> categoryIds) {
        Publisher publisher = publisherRepo.findById(publisherId)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
        book.setPublisher(publisher);
        List<Author> authors = authorRepo.findAllById(authorIds);
        if (authors.size() != authorIds.size()) {
            throw new RuntimeException("Some authors not found");
        }
        List<BookAuthors> bookAuthors = authors.stream()
                .map(author -> BookAuthors.builder().author(author).book(book).build())
                .toList();
        book.setBookAuthors(bookAuthors);
        List<Category> categories = categoryRepo.findAllById(categoryIds);
        if (categories.size() != categoryIds.size()) {
            throw new RuntimeException("Some categories not found");
        }
        List<BookCategories> bookCategories = categories.stream()
                .map(category -> BookCategories.builder().book(book).category(category).build())
                .toList();
        book.setBookCategories(bookCategories);
    }

    @Override
    public BookViewDTO getBook(String ISBN) {
        Book book = bookRepo.findByISBN(ISBN).orElseThrow(
                () -> new RuntimeException("Book not found"));
        BookViewDTO bookDTO = bookMapper.toBookResponseDTO(book);
        return bookDTO;
    }
}
