package com.alkhenaizi.springCrud.repositories;

import com.alkhenaizi.springCrud.TestDataUtil;
import com.alkhenaizi.springCrud.domain.entities.AuthorEntity;
import com.alkhenaizi.springCrud.domain.entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityRepositoryIntegrationTest {

    private BookRepository underTest;
    private AuthorRepository authorDaoImpl;

    @Autowired
    BookEntityRepositoryIntegrationTest(BookRepository underTest, AuthorRepository authorDao) {
        this.underTest = underTest;
        this.authorDaoImpl = authorDao;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        AuthorEntity authorEntity = TestDataUtil.CreateTestAuthor();
        BookEntity bookEntity = TestDataUtil.CreateTestBookTwo(authorEntity);

        authorDaoImpl.save(authorEntity);
        underTest.save(bookEntity);

        bookEntity.setAuthorEntity(authorEntity);

        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());

        assertThat(result.get()).isEqualTo(bookEntity);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        AuthorEntity authorEntity = TestDataUtil.CreateTestAuthor();
        BookEntity bookEntityOne = TestDataUtil.CreateTestBookTwo(authorEntity);
        BookEntity bookEntityTwo = TestDataUtil.CreateTestBookThree(authorEntity);

        bookEntityOne.setAuthorEntity(authorEntity);
        bookEntityTwo.setAuthorEntity(authorEntity);

        underTest.save(bookEntityOne);
        underTest.save(bookEntityTwo);

        Iterable<BookEntity> books = underTest.findAll();

        assertThat(books)
                .hasSize(2)
                .containsExactly(bookEntityOne, bookEntityTwo);
    }

    @Test
    public void testThatBookCanBeUpdated() {
        AuthorEntity authorEntity = TestDataUtil.CreateTestAuthor();
        BookEntity bookEntity = TestDataUtil.CreateTestBookTwo(authorEntity);

        bookEntity.setAuthorEntity(authorEntity);
        underTest.save(bookEntity);

        bookEntity.setTitle("Updated");
        underTest.save(bookEntity);

        Optional<BookEntity> updatedBook = underTest.findById(bookEntity.getIsbn());

        assertThat(updatedBook).isPresent();
        assertThat(updatedBook.get()).isEqualTo(bookEntity);
    }

    @Test
    public void testThatBookCanBeDeleted() {
        AuthorEntity authorEntity = TestDataUtil.CreateTestAuthor();
        BookEntity bookEntity = TestDataUtil.CreateTestBookTwo(authorEntity);

        bookEntity.setAuthorEntity(authorEntity);
        underTest.save(bookEntity);

        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
        assertThat(result).isPresent();

        underTest.deleteById(bookEntity.getIsbn());

        Optional<BookEntity> result2 = underTest.findById(bookEntity.getIsbn());
        assertThat(result2).isEmpty();
    }
}
