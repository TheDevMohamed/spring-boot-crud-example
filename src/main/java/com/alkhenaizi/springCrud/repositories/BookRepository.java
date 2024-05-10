package com.alkhenaizi.springCrud.repositories;

import com.alkhenaizi.springCrud.domain.entities.BookEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {
    @Transactional
    @Modifying
    @Query("update BookEntity b set b.isbn = ?1 where b.isbn = ?2")
    int updateIsbnByIsbn(String isbn, String isbn1);
}
