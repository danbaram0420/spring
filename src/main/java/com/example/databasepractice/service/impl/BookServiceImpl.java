package com.example.databasepractice.service.impl;

import com.example.databasepractice.data.dao.BookDAO;
import com.example.databasepractice.data.dao.impl.BookDAOImpl;
import com.example.databasepractice.data.entity.BookEntity;
import com.example.databasepractice.dto.BookDto;
import com.example.databasepractice.dto.BookResponseDto;
import com.example.databasepractice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    @Override
    public BookResponseDto getBook(Long book_id){
        BookEntity bookEntity = bookDAO.selectBook(book_id);

        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setBook_id(bookEntity.getBook_id());
        bookResponseDto.setAuthor(bookEntity.getAuthor());
        bookResponseDto.setTitle(bookEntity.getTitle());
        bookResponseDto.setPublisher(bookEntity.getPublisher());
        bookResponseDto.setCategory(bookEntity.getCategory());

        return bookResponseDto;
    }

    @Override
    public BookResponseDto saveBook(BookDto bookDto){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setPublisher(bookDto.getPublisher());
        bookEntity.setCategory(bookDto.getCategory());

        BookEntity savedBook = bookDAO.insertBook(bookEntity);

        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setBook_id(savedBook.getBook_id());
        bookResponseDto.setAuthor(savedBook.getAuthor());
        bookResponseDto.setTitle(savedBook.getTitle());
        bookResponseDto.setPublisher(savedBook.getPublisher());
        bookResponseDto.setCategory(savedBook.getCategory());

        return bookResponseDto;
    }

    @Override
    public BookResponseDto changeBookTitle(Long book_id, String title) throws Exception{
        BookEntity changedBook = bookDAO.updateBookTitle(book_id, title);

        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setBook_id(changedBook.getBook_id());
        bookResponseDto.setAuthor(changedBook.getAuthor());
        bookResponseDto.setTitle(changedBook.getTitle());
        bookResponseDto.setPublisher(changedBook.getPublisher());
        bookResponseDto.setCategory(changedBook.getCategory());

        return bookResponseDto;
    }

    @Override
    public void deleteBook(Long book_id) throws Exception{
        bookDAO.deleteBook(book_id);
    }

}
