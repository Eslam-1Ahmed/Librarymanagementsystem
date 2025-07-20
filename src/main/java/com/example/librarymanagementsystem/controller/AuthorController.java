package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.AuthorDTO;
import com.example.librarymanagementsystem.service.AuthorService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> add(@RequestBody AuthorDTO dto) {
        return ResponseEntity.ok(authorService.addAuthor(dto));
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> edit(@RequestBody AuthorDTO dto) {
        return ResponseEntity.ok(authorService.editAuthor(dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.deleteAuthor(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthor(id));
    }

    @GetMapping
    public ResponseEntity<Page<AuthorDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(authorService.getAllAuthors(page, size));
    }
}
