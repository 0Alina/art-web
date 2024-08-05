package com.application.art.service;

import com.application.art.entity.GalleryItem;
import com.application.art.repository.GalleryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryItemServiceImpl implements GalleryItemService {

    @Autowired
    private GalleryItemRepository galleryItemRepository;

    @Override
    public void save(GalleryItem galleryItem) {
        galleryItemRepository.save(galleryItem);
    }
}
