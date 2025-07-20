package com.example.librarymanagementsystem.mapper;

import org.springframework.stereotype.Component;

import com.example.librarymanagementsystem.DTO.BorrowingViewDTO;
import com.example.librarymanagementsystem.entity.BorrowingTransaction;

@Component
public class BorrowingTransactionMapper {
    public BorrowingViewDTO toBorrowingViewDTO(BorrowingTransaction borrowingTransaction) {
        return BorrowingViewDTO.builder()
                .bookId(borrowingTransaction.getBook().getId())
                .borrowDate(borrowingTransaction.getBorrowDate())
                .dueDate(borrowingTransaction.getDueDate())
                .returnDate(borrowingTransaction.getReturnDate())
                .username(borrowingTransaction.getMember().getUsername()).build();
    }
}
