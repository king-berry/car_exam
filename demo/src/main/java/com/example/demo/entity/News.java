package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

//    @Column(name = "detail", length = 1000, nullable = false)
//    private String detail;

    @Column(name = "image", length = 1000, nullable = false)
    private String image;

    @Column(name = "dateNews", nullable = false)
    @CreationTimestamp
    private LocalDateTime dateNews = LocalDateTime.now();
}
