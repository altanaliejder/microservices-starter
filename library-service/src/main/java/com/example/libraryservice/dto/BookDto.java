package com.example.libraryservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
    private BookIdDto id;
    private int bookYear;
    private String title;
    private String pressName;
    private String author;

}
