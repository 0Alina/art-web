package com.application.art.service;

import com.application.art.dto.NewsItemDto;
import com.application.art.entity.NewsItem;
import com.application.art.repository.NewsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsItemServiceImpl implements NewsItemService {

    @Autowired
    private NewsItemRepository newsItemRepository;

    @Override
    public void save(NewsItemDto newsItemDto) {

        NewsItem newsItem = new NewsItem();
        newsItem.setContent(newsItemDto.getContent());
        newsItem.setTitle(newsItemDto.getTitle());
        newsItem.setDate(newsItemDto.getDate());

        newsItemRepository.save(newsItem);
    }
}
