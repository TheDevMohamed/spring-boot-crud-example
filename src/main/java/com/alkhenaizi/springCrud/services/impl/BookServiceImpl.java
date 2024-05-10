package com.alkhenaizi.springCrud.services.impl;

import com.alkhenaizi.springCrud.domain.entities.BookEntity;
import com.alkhenaizi.springCrud.services.BookService;
import com.alkhenaizi.springCrud.repositories.BookRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity upsertBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }

    @Override
    public Optional<BookEntity> findOne(String isbn) {
        return bookRepository.findById(isbn);
    }


    @Override
    public Boolean isExist(String isbn) {
        return bookRepository.existsById(isbn);
    }
}
