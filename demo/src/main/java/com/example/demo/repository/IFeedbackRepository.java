package com.example.demo.repository;

import com.example.demo.entity.Feedback;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByFullName(String fullName, Pageable pageable);
    void deleteFeedbackById(long id);
}
