package com.example.librarymanagementsystem.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.librarymanagementsystem.DTO.CategoryTreeViewDTO;
import com.example.librarymanagementsystem.DTO.CateogoryVeiwDTO;
import com.example.librarymanagementsystem.entity.Category;

@Component
public class CategoryMapper {
    public CateogoryVeiwDTO toCateogoryVeiwDTO(Category category) {
        return CateogoryVeiwDTO.builder().id(category.getId()).name(category.getName()).build();
    }

    public CategoryTreeViewDTO toCategoryTreeViewDTO(Category category) {
        return CategoryTreeViewDTO.builder().id(category.getId()).name(category.getName()).childrens(
                category.getSubcategories() != null
                        ? category.getSubcategories().stream().map(this::toCategoryTreeViewDTO).toList()
                        : List.of())
                .build();
    }
}
