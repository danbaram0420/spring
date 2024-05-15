package com.example.databasepractice.data.dao.impl;

import com.example.databasepractice.data.dao.BookDAO;
import com.example.databasepractice.data.entity.BookEntity;
import com.example.databasepractice.data.repository.BookRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDAOImpl implements BookDAO {

    private final BookRepository bookRepository;

    @Autowired
    public BookDAOImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity insertBook(BookEntity bookEntity){
        BookEntity savedBook = bookRepository.save(bookEntity);

        return savedBook;
    }

    @Override
    public BookEntity selectBook(Long book_id){
        Optional<BookEntity> selectedBook = bookRepository.findById(book_id);
        BookEntity returnBook = selectedBook.get();

        return returnBook;

    }

    @Override
    public BookEntity updateBookTitle(Long book_id, String title) throws Exception{
        Optional<BookEntity> selectedBook = bookRepository.findById(book_id);

        BookEntity updatedBook;
        if (selectedBook.isPresent()) {
            BookEntity bookEntity = selectedBook.get();

            bookEntity.setTitle(title);

            updatedBook = bookRepository.save(bookEntity);
        } else {
            throw new Exception();
        }
        return updatedBook;
    }

    @Override
    public void deleteBook(Long book_id) throws Exception{
        Optional<BookEntity> selectedBook = bookRepository.findById(book_id);

        if (selectedBook.isPresent()) {
            BookEntity bookEntity = selectedBook.get();

            bookRepository.delete(bookEntity);
        } else {
            throw new Exception();
        }
    }
}
