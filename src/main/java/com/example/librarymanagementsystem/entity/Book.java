package com.example.librarymanagementsystem.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;

    private String ISBN;

    private String edtion;

    private String summary;

    private String coverImageUrl;

    private boolean isBorrowed;

    private Integer publicationYear;

    @ManyToOne
    @JoinColumn(name = "publisherId")
    private Publisher publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookCategories> bookCategories;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookAuthors> bookAuthors;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<BorrowingTransaction> borrowingTransactions;
}
