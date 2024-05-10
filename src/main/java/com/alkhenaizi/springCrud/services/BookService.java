package com.alkhenaizi.springCrud.services;

import com.alkhenaizi.springCrud.domain.entities.BookEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BookService {
    BookEntity upsertBook(String isbn, BookEntity book);

    Optional<BookEntity> findOne(String isbn);

    Boolean isExist(String isbn);
}
