package com.application.art.service;

import com.application.art.dto.GalleryItemDto;
import com.application.art.entity.GalleryItem;
import com.application.art.repository.GalleryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class GalleryItemServiceImpl implements GalleryItemService {

    @Autowired
    private GalleryItemRepository galleryItemRepository;

    @Override
    public void save(GalleryItemDto galleryItemDto, MultipartFile imageFile) {

        GalleryItem galleryItem = new GalleryItem();
        galleryItem.setTitle(galleryItemDto.getTitle());
        galleryItem.setDate(galleryItemDto.getDate());

        try {
            if (!imageFile.isEmpty()) {
                galleryItem.setImage(imageFile.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload image", e); // Add more specific error handling if needed
        }

        galleryItemRepository.save(galleryItem);
    }
}
