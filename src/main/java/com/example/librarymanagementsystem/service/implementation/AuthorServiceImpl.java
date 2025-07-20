package com.example.librarymanagementsystem.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.DTO.AuthorDTO;
import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.mapper.AuthorMapper;
import com.example.librarymanagementsystem.repository.AuthorRepo;
import com.example.librarymanagementsystem.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorMapper authorMapper;
    private final AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorMapper authorMapper, AuthorRepo authorRepo) {
        this.authorMapper = authorMapper;
        this.authorRepo = authorRepo;
    }

    @Override
    public String addAuthor(AuthorDTO authorDTO) {
        authorRepo.save(authorMapper.toEntity(authorDTO));
        return "Added Successfuly";
    }

    @Override
    public String editAuthor(AuthorDTO authorDTO) {
        Author author = authorRepo.findById(authorDTO.getId()).orElseThrow(
                () -> new RuntimeException("Author not found"));
        authorMapper.updateFromDTO(authorDTO, author);
        return "Edited Successfully";
    }

    @Override
    public String deleteAuthor(Long id) {
        if (!authorRepo.existsById(id)) {
            throw new RuntimeException("Author not found");
        }
        authorRepo.deleteById(id);
        return "Deleted Successfully";
    }

    @Override
    public Page<AuthorDTO> getAllAuthors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return authorRepo.findAll(pageable)
                .map(authorMapper::toDTO);
    }

    @Override
    public AuthorDTO getAuthor(Long id) {
        return authorMapper.toDTO(authorRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Author not found")));
    }

}
