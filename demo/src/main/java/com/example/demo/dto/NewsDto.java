package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class NewsDto {
    private int id;
    private String title;
    private String description;
//    private String detail;
    private String image;

//    @JsonFormat(pattern = "dd-MM-yyyy")
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
//    @CreationTimestamp
//    @UpdateTimestamp
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime dateNews;
}
