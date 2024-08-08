package com.application.art.service;

import com.application.art.dto.NewsItemDto;
import com.application.art.entity.NewsItem;
import org.springframework.web.multipart.MultipartFile;

public interface NewsItemService {
    void save(NewsItemDto newsItemDto, MultipartFile imageFile);
}
