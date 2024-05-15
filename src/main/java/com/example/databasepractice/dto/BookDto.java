package com.example.databasepractice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private String title;
    private String author;
    private String publisher;
    private String category;

    public BookDto(String title, String author, String publisher, String category){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }
}
