package com.example.demo.service;

import com.example.demo.dto.NewsDto;
import com.example.demo.form.news.NewsCreateForm;
import com.example.demo.form.news.NewsUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INewsService {
    Page<NewsDto> findAll(Pageable pageable);

    NewsDto create(NewsCreateForm form);

    NewsDto update(NewsUpdateForm form);

    void deleteById(Integer id);
}
