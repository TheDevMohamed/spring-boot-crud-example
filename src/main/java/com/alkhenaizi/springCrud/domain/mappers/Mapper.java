package com.alkhenaizi.springCrud.domain.mappers;

public interface Mapper<A, B> {

    B mapTo(A a);

    A mapFrom(B b);

}
