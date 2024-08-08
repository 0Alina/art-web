package com.application.art.service;

import com.application.art.dto.NewsItemDto;
import com.application.art.entity.NewsItem;
import com.application.art.repository.NewsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class NewsItemServiceImpl implements NewsItemService {

    @Autowired
    private NewsItemRepository newsItemRepository;

    @Override
    public void save(NewsItemDto newsItemDto, MultipartFile imageFile) {

        NewsItem newsItem = new NewsItem();
        newsItem.setContent(newsItemDto.getContent());
        newsItem.setTitle(newsItemDto.getTitle());
        newsItem.setDate(newsItemDto.getDate());

        try {
            if (!imageFile.isEmpty()) {
                newsItem.setImage(imageFile.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload image", e); // Add more specific error handling if needed
        }

        newsItemRepository.save(newsItem);
    }
}
