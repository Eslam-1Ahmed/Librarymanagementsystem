package com.example.librarymanagementsystem.DTO;


import lombok.Data;

@Data
public class MemberRequestDTO {
    private String username;

    private String name;

    private String address;

    private String email;

    private String phone;
}
