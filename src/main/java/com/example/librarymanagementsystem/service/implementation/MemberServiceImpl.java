package com.example.librarymanagementsystem.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.DTO.MemberRequestDTO;
import com.example.librarymanagementsystem.DTO.MemberViewDTO;
import com.example.librarymanagementsystem.entity.Member;
import com.example.librarymanagementsystem.mapper.MemberMapper;
import com.example.librarymanagementsystem.repository.MemberRepo;
import com.example.librarymanagementsystem.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepo memberRepo;
    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberRepo memberRepo, MemberMapper memberMapper) {
        this.memberRepo = memberRepo;
        this.memberMapper = memberMapper;
    }

    @Override
    public String addMember(MemberRequestDTO memberRequestDTO) {
        if (memberRepo.existsById(memberRequestDTO.getUsername())) {
            throw new RuntimeException("This username already used");
        }
        memberRepo.save(memberMapper.toEntity(memberRequestDTO));
        return "Added successfully";
    }

    @Override
    public String deleteMember(String username) {
        if (!memberRepo.existsById(username)) {
            throw new RuntimeException("Member not found");
        }
        memberRepo.deleteById(username);
        return "Deleted successfully";
    }

    @Override
    public String editMember(MemberRequestDTO memberRequestDTO) {
        Member member = memberRepo.findById(memberRequestDTO.getUsername()).orElseThrow(
                () -> new RuntimeException("Member not found"));
        member.setAddress(memberRequestDTO.getAddress());
        member.setEmail(memberRequestDTO.getEmail());
        member.setName(memberRequestDTO.getName());
        member.setPhone(memberRequestDTO.getPhone());
        memberRepo.save(member);
        return "Edited successfully";
    }

    @Override
    public MemberViewDTO getMember(String username) {
        return memberMapper.toMemberViewDTO(memberRepo.findById(username).orElseThrow(
                () -> new RuntimeException("Member not found")));
    }

    @Override
    public Page<MemberViewDTO> getAllMembers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("username"));
        return memberRepo.findAll(pageable).map(memberMapper::toMemberViewDTO);
    }

}
