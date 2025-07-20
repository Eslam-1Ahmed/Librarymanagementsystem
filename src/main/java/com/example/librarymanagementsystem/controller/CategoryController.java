package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.CategoryEditDTO;
import com.example.librarymanagementsystem.DTO.CateogoryVeiwDTO;
import com.example.librarymanagementsystem.DTO.CateogoryRequestDTO;
import com.example.librarymanagementsystem.DTO.CategoryTreeViewDTO;

import com.example.librarymanagementsystem.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> add(@RequestBody CateogoryRequestDTO dto) {
        return ResponseEntity.ok(categoryService.addCategory(dto));
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> edit(@RequestBody CategoryEditDTO dto) {
        return ResponseEntity.ok(categoryService.editCategory(dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryTreeViewDTO> getCategoryTree(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryTree(id));
    }

    @GetMapping
    public ResponseEntity<Page<CateogoryVeiwDTO>> getAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(categoryService.getAllCategories(page, size));
    }
}
