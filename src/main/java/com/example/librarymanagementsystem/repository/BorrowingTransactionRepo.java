package com.example.librarymanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.librarymanagementsystem.entity.BorrowingTransaction;
@Repository
public interface BorrowingTransactionRepo extends JpaRepository<BorrowingTransaction, Long> {
    @Query("SELECT bt FROM BorrowingTransaction bt WHERE bt.book.id = :bookId AND bt.member.username = :username AND bt.returnDate IS NULL")
    Optional<BorrowingTransaction> findByBookIdAndUsername(Long bookId, String username);
    
    Page<BorrowingTransaction> findByMember_Username(String username, Pageable pageable);
}
