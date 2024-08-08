package com.application.art.service;

import com.application.art.dto.GalleryItemDto;
import com.application.art.dto.NewsItemDto;
import com.application.art.entity.NewsItem;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NewsItemService {
    void save(NewsItemDto newsItemDto, MultipartFile imageFile);
    List<NewsItemDto> getAllNewsItems();
}
