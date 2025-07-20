package com.example.librarymanagementsystem.service;

import org.springframework.data.domain.Page;

import com.example.librarymanagementsystem.DTO.MemberRequestDTO;
import com.example.librarymanagementsystem.DTO.MemberViewDTO;

public interface MemberService {

    public String addMember(MemberRequestDTO memberRequestDTO);

    public String deleteMember(String username);

    public String editMember(MemberRequestDTO memberRequestDTO);

    public MemberViewDTO getMember(String username);

    public Page<MemberViewDTO> getAllMembers(int size, int page);

}
