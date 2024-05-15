package com.example.databasepractice.data.repository;

import com.example.databasepractice.data.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
