package com.example.librarymanagementsystem.DTO;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberViewDTO {
    private String username;

    private String name;

    private String address;

    private String email;

    private String phone;

    List<BorrowingViewDTO> borrowingList;
}
