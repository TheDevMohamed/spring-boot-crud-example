package com.alkhenaizi.springCrud.controllers;

import com.alkhenaizi.springCrud.domain.entities.AuthorEntity;
import com.alkhenaizi.springCrud.domain.mappers.Mapper;
import com.alkhenaizi.springCrud.services.AuthorService;
import com.alkhenaizi.springCrud.domain.dto.AuthorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {
    private AuthorService authorService;

    private Mapper<AuthorEntity, AuthorDTO> authorMapper;

    AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDTO> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO author) {
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity =  this.authorService.createAuthor(authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/authors")
    public List<AuthorDTO> listAuthors() {
        List<AuthorEntity> authors = authorService.findAll();
        return  authors
                    .stream()
                    .map(authorMapper::mapTo)
                    .collect(Collectors.toList());
    }
}
