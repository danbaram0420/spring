package com.example.databasepractice.controller;

import com.example.databasepractice.dto.BookDto;
import com.example.databasepractice.dto.BookResponseDto;
import com.example.databasepractice.dto.ChangeBookTitleDto;
import com.example.databasepractice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity<BookResponseDto> getBook(Long book_id) {
        BookResponseDto bookResponseDto = bookService.getBook(book_id);

        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDto);
    }

    @PostMapping()
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookDto bookDto){
        BookResponseDto bookResponseDto = bookService.saveBook(bookDto);

        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDto);
    }

    @PutMapping()
    public ResponseEntity<BookResponseDto> changeBookTitle(
        @RequestBody ChangeBookTitleDto changeBookTitleDto) throws Exception{
        BookResponseDto bookResponseDto = bookService.changeBookTitle(
            changeBookTitleDto.getBook_id(),
            changeBookTitleDto.getTitle());

        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBook(Long book_id) throws Exception{
        bookService.deleteBook(book_id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
    }

}
