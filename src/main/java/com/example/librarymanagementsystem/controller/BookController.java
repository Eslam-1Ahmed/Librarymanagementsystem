package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.BookEditDTO;
import com.example.librarymanagementsystem.DTO.BookRequestDTO;
import com.example.librarymanagementsystem.DTO.BookViewDTO;
import com.example.librarymanagementsystem.service.BookService;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> addBook(@RequestBody BookRequestDTO dto) {
        return ResponseEntity.ok(bookService.addBook(dto));
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> editBook(@RequestBody BookEditDTO dto) {
        return ResponseEntity.ok(bookService.editBook(dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookViewDTO> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @GetMapping
    public ResponseEntity<Page<BookViewDTO>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(bookService.getAllBooks(page, size));
    }
}
