package com.example.librarymanagementsystem.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.DTO.CategoryEditDTO;
import com.example.librarymanagementsystem.DTO.CategoryTreeViewDTO;
import com.example.librarymanagementsystem.DTO.CateogoryRequestDTO;
import com.example.librarymanagementsystem.DTO.CateogoryVeiwDTO;
import com.example.librarymanagementsystem.entity.Category;
import com.example.librarymanagementsystem.mapper.CategoryMapper;
import com.example.librarymanagementsystem.repository.CategoryRepo;
import com.example.librarymanagementsystem.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    public CategoryServiceImpl(CategoryRepo categoryRepo, CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

    private final CategoryMapper categoryMapper;

    @Override
    public String addCategory(CateogoryRequestDTO cateogoryRequestDTO) {
        Category parentCategory = categoryRepo.findById(cateogoryRequestDTO.getParentId()).orElseThrow(
                () -> new RuntimeException("Parent category not found"));
        categoryRepo
                .save(Category.builder().name(cateogoryRequestDTO.getName()).parentCategory(parentCategory).build());
        return "Added successfully";
    }

    @Override
    public String editCategory(CategoryEditDTO categoryEditDTO) {
        Category parentCategory = categoryRepo.findById(categoryEditDTO.getParentId()).orElseThrow(
                () -> new RuntimeException("Parent category not found"));

        Category category = categoryRepo.findById(categoryEditDTO.getId()).orElseThrow(
                () -> new RuntimeException("Category not found"));
        category.setName(category.getName());
        category.setParentCategory(parentCategory);
        categoryRepo.save(category);
        return "Edited successfully";
    }

    @Override
    public String deleteCategory(Long id) {
        if (!categoryRepo.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepo.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public Page<CateogoryVeiwDTO> getAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return categoryRepo.findAll(pageable).map(categoryMapper::toCateogoryVeiwDTO);
    }

    @Override
    public CategoryTreeViewDTO getCategoryTree(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Category not found"));
        return categoryMapper.toCategoryTreeViewDTO(category);
    }

}
