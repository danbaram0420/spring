package com.example.databasepractice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeBookTitleDto {
    private Long book_id;
    private String title;

    public ChangeBookTitleDto(Long book_id, String title){
        this.book_id = book_id;
        this.title = title;
    }

    public ChangeBookTitleDto(){
    }
}
