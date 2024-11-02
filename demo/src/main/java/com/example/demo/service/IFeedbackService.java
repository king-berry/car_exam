package com.example.demo.service;

import com.example.demo.dto.FeedbackDTO;
import com.example.demo.entity.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFeedbackService {
    Page<Feedback> getAllFeedbacks(Pageable pageable);

    Feedback getFeedbackById(long id);

    List<Feedback> getFeedbacksByFullName(String fullName, Pageable pageable);

    void createFeedback(FeedbackDTO feedbackDTO);

    void deleteFeedbackById(long id);
}
