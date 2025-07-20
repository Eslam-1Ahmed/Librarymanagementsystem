package com.example.librarymanagementsystem.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.librarymanagementsystem.DTO.MemberRequestDTO;
import com.example.librarymanagementsystem.DTO.MemberViewDTO;
import com.example.librarymanagementsystem.entity.Member;

@Component
public class MemberMapper {
    private final BorrowingTransactionMapper borrowingTransactionMapper;

    public MemberMapper(BorrowingTransactionMapper borrowingTransactionMapper) {
        this.borrowingTransactionMapper = borrowingTransactionMapper;
    }

    public Member toEntity(MemberRequestDTO memberRequestDTO) {
        return Member.builder().address(memberRequestDTO.getAddress()).createdAt(LocalDateTime.now())
                .email(memberRequestDTO.getEmail()).name(memberRequestDTO.getName()).phone(memberRequestDTO.getPhone())
                .username(memberRequestDTO.getUsername())
                .build();
    }

    public MemberViewDTO toMemberViewDTO(Member member) {
        return MemberViewDTO.builder()
                .address(member.getAddress()).borrowingList(member.getBorrowingTransactions().stream()
                        .map(borrowingTransactionMapper::toBorrowingViewDTO).toList())
                .email(member.getEmail())
                .name(member.getName()).phone(member.getPhone())
                .username(member.getUsername())
                .build();
    }
}
