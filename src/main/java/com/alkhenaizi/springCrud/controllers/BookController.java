package com.alkhenaizi.springCrud.controllers;

import com.alkhenaizi.springCrud.domain.entities.BookEntity;
import com.alkhenaizi.springCrud.domain.mappers.Mapper;
import com.alkhenaizi.springCrud.services.BookService;
import com.alkhenaizi.springCrud.domain.dto.BookDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookController {
    private BookService bookService;

    private Mapper<BookEntity, BookDTO> bookMapper;

    public BookController(BookService bookService, Mapper<BookEntity, BookDTO> bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDTO> findOne(@PathVariable String isbn) {
        return bookService.findOne(isbn).map(bookEntity -> {
                    BookDTO bookDTO = bookMapper.mapTo(bookEntity);
                    return new ResponseEntity<>(bookDTO, HttpStatus.OK);
                }
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDTO> upsert(@PathVariable String isbn, @RequestBody BookDTO bookDTO) {
        Boolean isExist = bookService.isExist(isbn);
        BookEntity bookEntity = bookMapper.mapFrom(bookDTO);
        BookEntity savedBookEntity = bookService.upsertBook(isbn, bookEntity);

        if (isExist) {
            return new ResponseEntity<>(bookMapper.mapTo(savedBookEntity), HttpStatus.OK);
        }

        return new ResponseEntity<>(bookMapper.mapTo(savedBookEntity), HttpStatus.CREATED);
    }
}