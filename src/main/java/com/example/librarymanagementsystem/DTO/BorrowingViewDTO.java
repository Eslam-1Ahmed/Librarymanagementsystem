package com.example.librarymanagementsystem.DTO;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BorrowingViewDTO {

    private Long id;

    private LocalDateTime borrowDate;

    private LocalDateTime dueDate;

    private LocalDateTime returnDate;

    private Long bookId;
    
    private String username;
}
