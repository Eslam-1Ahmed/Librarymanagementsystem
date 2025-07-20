package com.example.librarymanagementsystem.DTO;

import lombok.Data;

@Data
public class PublisherEditDTO {
    private Long id;

    private String name;

    private String address;

    private String contactEmail;

    private String contactPhone;
}
