package com.example.librarymanagementsystem.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublisherViewDTO {
    private Long id;

    private String name;

    private String address;

    private String contactEmail;

    private String contactPhone;
}
