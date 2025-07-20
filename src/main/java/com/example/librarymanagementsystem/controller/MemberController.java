package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.MemberRequestDTO;
import com.example.librarymanagementsystem.DTO.MemberViewDTO;
import com.example.librarymanagementsystem.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> add(@RequestBody MemberRequestDTO dto) {
        return ResponseEntity.ok(memberService.addMember(dto));
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> edit(@RequestBody MemberRequestDTO dto) {
        return ResponseEntity.ok(memberService.editMember(dto));
    }

    @DeleteMapping("/{username}")
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> delete(@PathVariable String username) {
        return ResponseEntity.ok(memberService.deleteMember(username));
    }

    @GetMapping("/{username}")
    public ResponseEntity<MemberViewDTO> get(@PathVariable String username) {
        return ResponseEntity.ok(memberService.getMember(username));
    }

    @GetMapping
    public ResponseEntity<Page<MemberViewDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(memberService.getAllMembers(page, size));
    }
}
