package com.application.art.repository;

import com.application.art.entity.NewsItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsItemRepository extends JpaRepository<NewsItem, Long> {
}
