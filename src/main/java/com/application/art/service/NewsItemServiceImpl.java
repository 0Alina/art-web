package com.application.art.service;

import com.application.art.dto.GalleryItemDto;
import com.application.art.dto.NewsItemDto;
import com.application.art.entity.GalleryItem;
import com.application.art.entity.NewsItem;
import com.application.art.repository.NewsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
        newsItem.setCategory(newsItemDto.getCategory());
        newsItem.setAuthor(newsItemDto.getAuthor());
        newsItem.setDescription(newsItemDto.getDescription());

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

    @Override
    public List<NewsItemDto> getAllNewsItems() {
        List<NewsItem> newsItems = newsItemRepository.findAll();
        return newsItems.stream()
                .map((newsItem) -> mapToNewsItem(newsItem))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(newsItemRepository.existsById(id)) {
            newsItemRepository.deleteById(id);
        }
    }

    private NewsItemDto mapToNewsItem(NewsItem newsItem) {
        NewsItemDto newsItemDto = new NewsItemDto();
        newsItemDto.setId(newsItem.getId());
        newsItemDto.setTitle(newsItem.getTitle());
        newsItemDto.setDate(newsItem.getDate());
        newsItemDto.setBase64Image(newsItem.getBase64Image());

        return newsItemDto;
    }
}
