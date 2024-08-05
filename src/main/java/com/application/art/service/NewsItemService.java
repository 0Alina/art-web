package com.application.art.service;

import com.application.art.dto.NewsItemDto;
import com.application.art.entity.NewsItem;

public interface NewsItemService {
    void save(NewsItemDto newsItemDto);
}
