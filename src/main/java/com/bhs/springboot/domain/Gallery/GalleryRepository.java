package com.bhs.springboot.domain.Gallery;


import org.springframework.data.jpa.repository.JpaRepository;
import com.bhs.springboot.domain.Gallery.GalleryEntity;

public interface GalleryRepository extends JpaRepository<GalleryEntity, Long> {
}
