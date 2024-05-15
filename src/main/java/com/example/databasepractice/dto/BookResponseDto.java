package com.example.databasepractice.dto;

import com.example.databasepractice.data.repository.BookRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDto {
    private Long book_id;
    private String title;
    private String author;
    private String publisher;
    private String category;

    public BookResponseDto(){}

    public BookResponseDto(Long book_id, String title, String author, String publisher, String category) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }
}
