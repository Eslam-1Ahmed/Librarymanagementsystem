package com.example.librarymanagementsystem.DTO;

import lombok.Data;

@Data
public class CateogoryRequestDTO {
    private String name;
    private Long parentId;
}
