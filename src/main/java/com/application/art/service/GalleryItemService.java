package com.application.art.service;

import com.application.art.dto.GalleryItemDto;
import org.springframework.web.multipart.MultipartFile;

public interface GalleryItemService {
    void save(GalleryItemDto galleryItemDto, MultipartFile imageFile);
}
