package com.bhs.springboot.domain.Gallery;


import org.springframework.data.jpa.repository.JpaRepository;
import com.bhs.springboot.domain.Gallery.GalleryEntity;

import java.util.List;

public interface GalleryRepository extends JpaRepository<GalleryEntity, Long> {

    @Override
    List<GalleryEntity> findAll();
}