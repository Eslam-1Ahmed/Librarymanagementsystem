package com.example.librarymanagementsystem.service;

import org.springframework.data.domain.Page;

import com.example.librarymanagementsystem.DTO.CategoryEditDTO;
import com.example.librarymanagementsystem.DTO.CategoryTreeViewDTO;
import com.example.librarymanagementsystem.DTO.CateogoryRequestDTO;
import com.example.librarymanagementsystem.DTO.CateogoryVeiwDTO;

public interface CategoryService {
    public String addCategory(CateogoryRequestDTO cateogoryRequestDTO);

    public String editCategory(CategoryEditDTO categoryEditDTO);

    public String deleteCategory(Long id);

    public Page<CateogoryVeiwDTO> getAllCategories(int page, int size);

    public CategoryTreeViewDTO getCategoryTree(Long id);
}
