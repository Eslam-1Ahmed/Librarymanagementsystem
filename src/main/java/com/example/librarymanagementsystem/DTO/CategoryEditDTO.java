package com.example.librarymanagementsystem.DTO;

import lombok.Data;

@Data
public class CategoryEditDTO {
    private Long id;
    private String name;
    private Long parentId;
}
