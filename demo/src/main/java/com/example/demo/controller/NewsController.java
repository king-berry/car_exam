package com.example.demo.controller;

import com.example.demo.dto.NewsDto;
import com.example.demo.form.news.NewsCreateForm;
import com.example.demo.form.news.NewsUpdateForm;
import com.example.demo.service.INewsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class NewsController {
    @Autowired
    private INewsService newsService;

    @Autowired
    public ModelMapper modelMapper;

    @GetMapping("/news")
    public Page<NewsDto> findAll(Pageable pageable) {
        return newsService.findAll(pageable);
    }

    @PostMapping("/news")
    public NewsDto create(@RequestBody NewsCreateForm form) {
        return newsService.create(form);
    }

    @PutMapping("/news/{id}")
    public NewsDto create(@RequestBody NewsUpdateForm form, @PathVariable("id") Integer id) {
        form.setId(id);
        return newsService.update(form);
    }

    @DeleteMapping("/news/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        newsService.deleteById(id);
    }
}
