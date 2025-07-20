package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.PublisherRequestDTO;
import com.example.librarymanagementsystem.DTO.PublisherEditDTO;
import com.example.librarymanagementsystem.DTO.PublisherViewDTO;
import com.example.librarymanagementsystem.service.PublisherService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> add(@RequestBody PublisherRequestDTO dto) {
        return ResponseEntity.ok(publisherService.addPublisher(dto));
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> edit(@RequestBody PublisherEditDTO dto) {
        return ResponseEntity.ok(publisherService.editPublisher(dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRATORS', 'LIBRARIANS')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.deletePublisher(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherViewDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.getPublisher(id));
    }

    @GetMapping
    public ResponseEntity<Page<PublisherViewDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(publisherService.getAllPublishers(page, size));
    }
}
