package com.example.librarymanagementsystem.service;

import org.springframework.data.domain.Page;

import com.example.librarymanagementsystem.DTO.PublisherEditDTO;
import com.example.librarymanagementsystem.DTO.PublisherRequestDTO;
import com.example.librarymanagementsystem.DTO.PublisherViewDTO;

public interface PublisherService {
    public String addPublisher(PublisherRequestDTO publisherRequestDTO);

    public String editPublisher(PublisherEditDTO publisherEditDTO);

    public String deletePublisher(Long id);

    public Page<PublisherViewDTO> getAllPublishers(int page, int size);

    public PublisherViewDTO getPublisher(Long id);
}
