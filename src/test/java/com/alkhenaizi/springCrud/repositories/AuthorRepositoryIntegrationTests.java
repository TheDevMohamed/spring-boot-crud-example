package com.alkhenaizi.springCrud.repositories;

import com.alkhenaizi.springCrud.TestDataUtil;
import com.alkhenaizi.springCrud.domain.entities.AuthorEntity;
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
public class AuthorRepositoryIntegrationTests {

    private AuthorRepository underTest;

    @Autowired
    public AuthorRepositoryIntegrationTests(AuthorRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        AuthorEntity authorEntity = TestDataUtil.CreateTestAuthor();
        underTest.save(authorEntity);
        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorEntity);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        AuthorEntity authorEntityOne = TestDataUtil.CreateTestAuthor();
        AuthorEntity authorEntityTwo = TestDataUtil.CreateTestAuthorTwo();

        underTest.save(authorEntityOne);
        underTest.save(authorEntityTwo);

        Iterable<AuthorEntity> authors = underTest.findAll();

        assertThat(authors)
                .hasSize(2)
                .containsExactly(authorEntityOne, authorEntityTwo);
    }

    @Test
    public void testThatGetAuthorWithAgeLessThan() {
        AuthorEntity authorEntityOne = TestDataUtil.CreateTestAuthor();
        AuthorEntity authorEntityTwo = TestDataUtil.CreateTestAuthorTwo();

        underTest.save(authorEntityOne);
        underTest.save(authorEntityTwo);

        Iterable<AuthorEntity> result = underTest.ageLessThan(15);

        assertThat(result).containsExactly(authorEntityOne);
    }

    @Test
    public void testThatGetAuthorWithAgeGreaterThan() {
        AuthorEntity authorEntityOne = TestDataUtil.CreateTestAuthor();
        AuthorEntity authorEntityTwo = TestDataUtil.CreateTestAuthorTwo();

        underTest.save(authorEntityOne);
        underTest.save(authorEntityTwo);

        Iterable<AuthorEntity> result = underTest.findAuthorsWithAgeGreaterThan(15);

        assertThat(result).containsExactly(authorEntityTwo);
    }
}