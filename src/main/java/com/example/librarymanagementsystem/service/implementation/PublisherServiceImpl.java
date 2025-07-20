package com.example.librarymanagementsystem.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.DTO.PublisherEditDTO;
import com.example.librarymanagementsystem.DTO.PublisherRequestDTO;
import com.example.librarymanagementsystem.DTO.PublisherViewDTO;
import com.example.librarymanagementsystem.entity.Publisher;
import com.example.librarymanagementsystem.mapper.PublisherMapper;
import com.example.librarymanagementsystem.repository.PublisherRepo;
import com.example.librarymanagementsystem.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherMapper publisherMapper;
    private final PublisherRepo publisherRepo;

    public PublisherServiceImpl(PublisherMapper publisherMapper, PublisherRepo publisherRepo) {
        this.publisherMapper = publisherMapper;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public String addPublisher(PublisherRequestDTO publisherRequestDTO) {
        Publisher publisher = publisherMapper.toEntity(publisherRequestDTO);
        publisherRepo.save(publisher);
        return "Added successfully";
    }

    @Override
    public String editPublisher(PublisherEditDTO publisherEditDTO) {
        Publisher publisher = publisherRepo.findById(publisherEditDTO.getId()).orElseThrow(
                () -> new RuntimeException("Publisher not found"));
        publisher.setAddress(publisherEditDTO.getAddress());
        publisher.setContactEmail(publisherEditDTO.getContactEmail());
        publisher.setContactPhone(publisherEditDTO.getContactPhone());
        publisher.setName(publisherEditDTO.getName());
        publisherRepo.save(publisher);
        return "Edited Successfully";
    }

    @Override
    public String deletePublisher(Long id) {
        if (!publisherRepo.existsById(id)) {
            throw new RuntimeException("Publisher not found");
        }
        publisherRepo.deleteById(id);
        return "Deleted Successfully";
    }

    @Override
    public Page<PublisherViewDTO> getAllPublishers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return publisherRepo.findAll(pageable).map(publisherMapper::toPublisherViewDTO);
    }

    @Override
    public PublisherViewDTO getPublisher(Long id) {
        return publisherMapper.toPublisherViewDTO(publisherRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Publisher not found")));
    }

}
