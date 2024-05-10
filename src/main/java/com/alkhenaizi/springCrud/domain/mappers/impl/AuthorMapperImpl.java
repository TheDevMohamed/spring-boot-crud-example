package com.alkhenaizi.springCrud.domain.mappers.impl;

import com.alkhenaizi.springCrud.domain.dto.AuthorDTO;
import com.alkhenaizi.springCrud.domain.entities.AuthorEntity;
import com.alkhenaizi.springCrud.domain.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDTO> {

    private ModelMapper modelMapper;

    AuthorMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDTO mapTo(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity, AuthorDTO.class);
    }

    @Override
    public AuthorEntity mapFrom(AuthorDTO authorDTO) {
        return modelMapper.map(authorDTO, AuthorEntity.class);
    }
}
