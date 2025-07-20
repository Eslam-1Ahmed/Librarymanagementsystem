package com.example.librarymanagementsystem.DTO;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorDTO {
    private Long id;

    private String name;

    private String bio;

    private Date dateOfBirth;
}
