package com.example.librarymanagementsystem.DTO;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookViewDTO {
    private Long id;

    private String language;

    private String ISBN;

    private String edtion;

    private String summary;

    private String coverImageUrl;

    private Integer publicationYear;

    private PublisherViewDTO publisher;
    private boolean isBorrowed;

    private List<CateogoryVeiwDTO> bookCategories;

    private List<AuthorDTO> bookAuthors;
}
