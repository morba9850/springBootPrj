package com.bhs.springboot.domain.Gallery;


import com.bhs.springboot.dto.GalleryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bhs.springboot.domain.Gallery.GalleryEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GalleryRepository extends JpaRepository<GalleryEntity, Long> {

    List<GalleryDto> findDesc();

}