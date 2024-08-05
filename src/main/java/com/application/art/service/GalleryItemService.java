package com.application.art.service;

import com.application.art.dto.GalleryItemDto;
import com.application.art.entity.GalleryItem;

public interface GalleryItemService {
    void save(GalleryItemDto galleryItemDto);
}
