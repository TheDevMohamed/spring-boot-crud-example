package com.alkhenaizi.springCrud.services;

import com.alkhenaizi.springCrud.domain.entities.AuthorEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);

    List<AuthorEntity> findAll();
}
