package com.example.librarymanagementsystem.DTO;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryTreeViewDTO {
    private Long id;
    private String name;
    List<CategoryTreeViewDTO> childrens;
}
