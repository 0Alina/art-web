package com.application.art.service;

import com.application.art.dto.GalleryItemDto;
import com.application.art.entity.GalleryItem;
import com.application.art.repository.GalleryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GalleryItemServiceImpl implements GalleryItemService {

    @Autowired
    private GalleryItemRepository galleryItemRepository;

    @Override
    public List<GalleryItemDto> getAllGalleryItems() {
        List<GalleryItem> galleryItems = galleryItemRepository.findAll();
        Collections.reverse(galleryItems); // inversare locală
        return galleryItems.stream()
                .map(this::mapToGalleryItem)
                .collect(Collectors.toList());
    }

    public List<GalleryItemDto> getRecentGalleryItems(int count) {
        return getAllGalleryItems().stream()
                .limit(count)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if(galleryItemRepository.existsById(id)) {
            galleryItemRepository.deleteById(id);
        }
    }

    private GalleryItemDto mapToGalleryItem(GalleryItem galleryItem) {
        GalleryItemDto galleryItemDto = new GalleryItemDto();
        galleryItemDto.setId(galleryItem.getId());
        galleryItemDto.setTitle(galleryItem.getTitle());
        galleryItemDto.setDate(galleryItem.getDate());
        galleryItemDto.setBase64Image(galleryItem.getBase64Image());

        return galleryItemDto;
    }

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
