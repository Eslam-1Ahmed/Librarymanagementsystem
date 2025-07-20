package com.example.librarymanagementsystem.service.implementation;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.DTO.BorrowingViewDTO;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.entity.BorrowingTransaction;
import com.example.librarymanagementsystem.entity.Member;
import com.example.librarymanagementsystem.mapper.BorrowingTransactionMapper;
import com.example.librarymanagementsystem.repository.BookRepo;
import com.example.librarymanagementsystem.repository.BorrowingTransactionRepo;
import com.example.librarymanagementsystem.repository.MemberRepo;
import com.example.librarymanagementsystem.service.BorrowingTransactionService;

import jakarta.transaction.Transactional;

@Service
public class BorrowingTransactionServiceImpl implements BorrowingTransactionService {
    private final BookRepo bookRepo;
    private final BorrowingTransactionRepo borrowingTransactionRepo;
    private final MemberRepo memberRepo;
    private final BorrowingTransactionMapper borrowingTransactionMapper;

    public BorrowingTransactionServiceImpl(BookRepo bookRepo, BorrowingTransactionRepo borrowingTransactionRepo,
            MemberRepo memberRepo, BorrowingTransactionMapper borrowingTransactionMapper) {
        this.bookRepo = bookRepo;
        this.borrowingTransactionRepo = borrowingTransactionRepo;
        this.memberRepo = memberRepo;
        this.borrowingTransactionMapper = borrowingTransactionMapper;
    }

    @Override
    @Transactional
    public String borrowBook(String username, Long bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        Member member = memberRepo.findById(username).orElseThrow(() -> new RuntimeException("Member not found"));
        if (book.isBorrowed()) {
            throw new RuntimeException("Book is borrowed");
        }
        borrowingTransactionRepo.save(BorrowingTransaction.builder()
                .book(book).member(member).borrowDate(LocalDateTime.now()).dueDate(LocalDateTime.now().plusDays(7))
                .build());
        return "Borrowed successfully";
    }

    @Override
    public String returnBook(String username, Long bookId) {
        BorrowingTransaction borrowingTransaction = borrowingTransactionRepo.findByBookIdAndUsername(bookId, username)
                .orElseThrow(
                        () -> new RuntimeException("No borrowing transaction"));
        borrowingTransaction.setReturnDate(LocalDateTime.now());
        borrowingTransactionRepo.save(borrowingTransaction);
        return "Returned successfully";
    }

    @Override
    public Page<BorrowingViewDTO> getAllBorrowings(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return borrowingTransactionRepo.findAll(pageable).map(borrowingTransactionMapper::toBorrowingViewDTO);
    }

    @Override
    public Page<BorrowingViewDTO> getBorrowingsByMember(String username, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return borrowingTransactionRepo.findByMember_Username(username, pageable)
                .map(borrowingTransactionMapper::toBorrowingViewDTO);
    }

}
