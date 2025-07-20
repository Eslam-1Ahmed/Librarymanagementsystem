package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.BorrowingViewDTO;
import com.example.librarymanagementsystem.service.BorrowingTransactionService;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingTransactionController {
    private final BorrowingTransactionService borrowingService;

    public BorrowingTransactionController(BorrowingTransactionService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @PostMapping("/borrow")
    @PreAuthorize("hasRole('LIBRARIANS')")
    public ResponseEntity<String> borrow(@RequestParam Long bookId, @RequestParam String username) {
        return ResponseEntity.ok(borrowingService.borrowBook(username, bookId));
    }

    @PostMapping("/return")
    @PreAuthorize("hasRole('LIBRARIANS')")
    public ResponseEntity<String> returnBook(@RequestParam Long bookId, @RequestParam String username) {
        return ResponseEntity.ok(borrowingService.returnBook(username, bookId));
    }

    @GetMapping("/member/{username}")
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<Page<BorrowingViewDTO>> getBorrowings(@PathVariable String username,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(borrowingService.getBorrowingsByMember(username, page, size));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<Page<BorrowingViewDTO>> getAllBorrowings(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(borrowingService.getAllBorrowings(page, size));
    }
}
