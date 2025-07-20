package com.example.librarymanagementsystem.DTO;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookRequestDTO {

    private String language;

    private String ISBN;

    private String edtion;

    private String summary;

    private String coverImageUrl;

    private Integer publicationYear;

    private Long publisherId;

    private List<Long> categoryIds;
    private List<Long> authorIds;
}
