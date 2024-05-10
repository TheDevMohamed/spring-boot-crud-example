package com.alkhenaizi.springCrud;

import com.alkhenaizi.springCrud.domain.entities.AuthorEntity;
import com.alkhenaizi.springCrud.domain.entities.BookEntity;
import com.alkhenaizi.springCrud.domain.dto.AuthorDTO;
import com.alkhenaizi.springCrud.domain.dto.BookDTO;


public final class TestDataUtil {

    private TestDataUtil(){
    }
    public static AuthorEntity CreateTestAuthor() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(10)
                .build();
    }

    public static AuthorEntity CreateTestAuthorTwo() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Mohamed Ali")
                .age(50)
                .build();
    }

    public static BookDTO CreateTestBookDto(final AuthorDTO author) {
        return BookDTO.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .author(author)
                .build();
    }

    public static BookEntity CreateTestBookTwo(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("1212-1-2345-6789-0")
                .title("The Attack")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity CreateTestBookThree(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("1212-1-2345-6789-99")
                .title("The Attack 2")
                .authorEntity(authorEntity)
                .build();
    }
}
