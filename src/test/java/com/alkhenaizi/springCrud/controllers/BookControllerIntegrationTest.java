package com.alkhenaizi.springCrud.controllers;

import com.alkhenaizi.springCrud.domain.entities.BookEntity;
import com.alkhenaizi.springCrud.services.BookService;
import com.alkhenaizi.springCrud.TestDataUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class BookControllerIntegrationTest {

    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    private BookService bookService;

    @Autowired
    BookControllerIntegrationTest(MockMvc mockMvc, ObjectMapper objectMapper, BookService bookService) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
        this.bookService = bookService;
    }

    @Test
    public void testThatCreateBookReturnsHttp201Created() throws Exception {
        BookEntity bookDTO = TestDataUtil.CreateTestBookTwo(null);
        String bookJson = objectMapper.writeValueAsString(bookDTO);

        bookService.upsertBook(bookDTO.getIsbn(), bookDTO);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + bookDTO.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value(bookDTO.getIsbn())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value(bookDTO.getTitle())
        );
    }

    @Test
    public void testThatUpdateBookReturnsHttp200Ok() throws Exception {
        BookEntity bookEntity = TestDataUtil.CreateTestBookTwo(null);
        bookService.upsertBook(bookEntity.getIsbn(), bookEntity);

        String newTitle = "newTitle";
        bookEntity.setTitle(newTitle);

        String bookJson = objectMapper.writeValueAsString(bookEntity);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/books/" + bookEntity.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value(bookEntity.getIsbn())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value(newTitle)
        );
    }

    @Test
    public void testThatFindOneBookReturnsHttp201Created() throws Exception {
        BookEntity book = TestDataUtil.CreateTestBookTwo(null);
        bookService.upsertBook(book.getIsbn(), book);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/books/" + book.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value(book.getIsbn())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.title").value(book.getTitle())
        );
    }

    @Test
    public void testThatFindOneBookReturnsHttp404WhenBookDoesNotExist() throws Exception {
        BookEntity book = TestDataUtil.CreateTestBookTwo(null);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/books/" + book.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isNotFound()
        );
    }

    @Test
    public void testThatDeleteBookReturnsHttp200Ok() throws Exception {
        BookEntity book = TestDataUtil.CreateTestBookTwo(null);
        bookService.upsertBook(book.getIsbn(), book);
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/books/" + book.getIsbn())
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.isbn").value(book.getIsbn())
        );
    }
}
