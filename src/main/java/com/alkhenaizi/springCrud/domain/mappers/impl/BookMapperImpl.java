package com.alkhenaizi.springCrud.domain.mappers.impl;

import com.alkhenaizi.springCrud.domain.entities.BookEntity;
import com.alkhenaizi.springCrud.domain.dto.BookDTO;
import com.alkhenaizi.springCrud.domain.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements Mapper<BookEntity, BookDTO> {
    private ModelMapper modelMapper;

    BookMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDTO mapTo(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDTO.class);
    }

    @Override
    public BookEntity mapFrom(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, BookEntity.class);
    }
}
