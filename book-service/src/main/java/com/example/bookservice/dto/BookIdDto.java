package com.example.bookservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookIdDto {
    private String id;
    private String isbn;


    public static BookIdDto convert(String id,String isbn){
        return BookIdDto.builder().id(id).isbn(isbn).build();
    }
}
