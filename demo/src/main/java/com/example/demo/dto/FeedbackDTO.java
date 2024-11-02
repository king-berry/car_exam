package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class FeedbackDTO {
    private long id;
    private String fullName;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime sendDate;
    private String messagesContent;
}
