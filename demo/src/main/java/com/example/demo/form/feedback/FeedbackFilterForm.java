package com.example.demo.form.feedback;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class FeedbackFilterForm {
    private int id;
    private String fullName;
    private String messagesContent;
    private LocalDateTime sendDate;
}
