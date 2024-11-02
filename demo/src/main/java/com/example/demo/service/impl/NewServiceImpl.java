package com.example.demo.service.impl;

import com.example.demo.dto.NewsDto;
import com.example.demo.entity.News;
import com.example.demo.form.news.NewsCreateForm;
import com.example.demo.form.news.NewsUpdateForm;
import com.example.demo.repository.NewsRepository;
import com.example.demo.service.INewsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NewServiceImpl implements INewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<NewsDto> findAll(Pageable pageable) {
        return newsRepository.findAll(pageable).map(news -> modelMapper.map(news, NewsDto.class));
    }

    @Override
    public NewsDto create(NewsCreateForm form) {
        News news = modelMapper.map(form, News.class);
        var savedNews = newsRepository.save(news);
        return modelMapper.map(savedNews, NewsDto.class);
    }

    @Override
    public NewsDto update(NewsUpdateForm form) {
        News news = modelMapper.map(form, News.class);
        var savedNews = newsRepository.save(news);
        return modelMapper.map(savedNews, NewsDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        newsRepository.deleteById(id);
    }
}
