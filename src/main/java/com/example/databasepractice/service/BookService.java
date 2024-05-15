package com.example.databasepractice.service;

import com.example.databasepractice.dto.BookDto;
import com.example.databasepractice.dto.BookResponseDto;

public interface BookService {
    BookResponseDto getBook(Long book_id);

    BookResponseDto saveBook(BookDto bookDto);

    BookResponseDto changeBookTitle(Long book_id, String title) throws Exception;

    void deleteBook(Long book_id) throws Exception;
}
