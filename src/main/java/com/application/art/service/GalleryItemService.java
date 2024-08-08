package com.application.art.service;

import com.application.art.dto.GalleryItemDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GalleryItemService {

    void save(GalleryItemDto galleryItemDto, MultipartFile imageFile);

    List<GalleryItemDto> getAllGalleryItems();

    void delete(Long id);
}
