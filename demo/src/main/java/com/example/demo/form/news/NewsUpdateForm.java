package com.example.demo.form.news;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsUpdateForm {
    private int id;
    private String title;
    private String description;
//    private String detail;
    private String image;
}
