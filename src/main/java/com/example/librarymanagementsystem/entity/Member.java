package com.example.librarymanagementsystem.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    private String username;

    private String name;

    private String address;

    private String email;

    private String phone;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "member")
    List<BorrowingTransaction> borrowingTransactions;
}
