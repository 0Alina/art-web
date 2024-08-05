package com.application.art.service;

import com.application.art.entity.NewsItem;
import com.application.art.repository.NewsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsItemServiceImpl implements NewsItemService {

    @Autowired
    private NewsItemRepository newsItemRepository;

    @Override
    public void save(NewsItem newsItem) {
        newsItemRepository.save(newsItem);
    }
}
