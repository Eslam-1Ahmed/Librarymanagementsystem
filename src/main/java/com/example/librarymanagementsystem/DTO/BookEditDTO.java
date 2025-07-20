package com.example.librarymanagementsystem.DTO;

import java.util.List;
import lombok.Data;

@Data
public class BookEditDTO {
    private Long id; 
    private String title;
    private String ISBN;
    private String summary;
    private String language;
    private String edtion;
    private Integer publicationYear;
    private String coverImageUrl;
    private Long publisherId;
    private List<Long> authorIds;
    private List<Long> categoryIds;
}
