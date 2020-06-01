package com.bhs.springboot.service;

import com.bhs.springboot.domain.Gallery.GalleryRepository;
import com.bhs.springboot.dto.GalleryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GalleryService {
    private GalleryRepository galleryRepository;

    public void savePost(GalleryDto galleryDto) {
        galleryRepository.save(galleryDto.toEntity());
    }
}
