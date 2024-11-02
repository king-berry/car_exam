package com.example.demo.controller;

import com.example.demo.dto.FeedbackDTO;
import com.example.demo.entity.Feedback;
import com.example.demo.service.IFeedbackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/feedbacks")
@CrossOrigin("*")
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;
    @Autowired
    public ModelMapper modelMapper;

    @GetMapping
    public Page<Feedback> getAllFeedbacks(Pageable pageable){
        return feedbackService.getAllFeedbacks(pageable);
    }

     @GetMapping("/fullName")
        public List<Feedback> getFeedbacksByFullName(
        @RequestParam(name = "fullName") String fullName,
        Pageable pageable) {
           return feedbackService.getFeedbacksByFullName(fullName, pageable);
        }

    @PostMapping("/create")
    public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody FeedbackDTO feedbackDto) {
        try {
            feedbackDto.setSendDate(LocalDateTime.now());
            feedbackService.createFeedback(feedbackDto);
            return new ResponseEntity<>(feedbackDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(feedbackDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
        try {
            feedbackService.deleteFeedbackById(id);
            return new ResponseEntity<>("Feedback deleted successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete feedback.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
