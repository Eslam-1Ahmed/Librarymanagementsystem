package com.example.librarymanagementsystem.mapper;

import org.springframework.stereotype.Component;

import com.example.librarymanagementsystem.DTO.PublisherRequestDTO;
import com.example.librarymanagementsystem.DTO.PublisherViewDTO;
import com.example.librarymanagementsystem.entity.Publisher;

@Component
public class PublisherMapper {
    public PublisherViewDTO toPublisherViewDTO(Publisher publisher) {
        return PublisherViewDTO.builder()
                .address(publisher.getAddress()).contactEmail(publisher.getContactEmail())
                .contactPhone(publisher.getContactPhone()).id(publisher.getId()).name(publisher.getName()).build();
    }

    public Publisher toEntity(PublisherRequestDTO publisherRequestDTO) {
        return Publisher.builder()
                .address(publisherRequestDTO.getAddress()).contactEmail(publisherRequestDTO.getContactEmail())
                .contactPhone(publisherRequestDTO.getContactPhone()).name(publisherRequestDTO.getName()).build();
    }
}
