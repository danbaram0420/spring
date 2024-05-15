package com.example.databasepractice.data.dao;

import com.example.databasepractice.data.entity.BookEntity;

public interface BookDAO {

    BookEntity insertBook(BookEntity bookEntity);

    BookEntity selectBook(Long book_id);

    BookEntity updateBookTitle(Long book_id, String title) throws Exception;

    void deleteBook(Long book_id) throws Exception;

}
