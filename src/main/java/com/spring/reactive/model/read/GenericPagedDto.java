package com.spring.reactive.model.read;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class GenericPagedDto<T> extends PageImpl<T> {

    public GenericPagedDto(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public GenericPagedDto(List<T> content) {
        super(content);
    }
    
}
