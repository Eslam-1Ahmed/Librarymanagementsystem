package com.example.librarymanagementsystem.service;

import org.springframework.data.domain.Page;

import com.example.librarymanagementsystem.DTO.BorrowingViewDTO;

public interface BorrowingTransactionService {
    public String borrowBook(String username, Long bookId);

    public String returnBook(String username, Long bookId);

    public Page<BorrowingViewDTO> getAllBorrowings(int page, int size);

    public Page<BorrowingViewDTO> getBorrowingsByMember(String username, int page, int size);
}
