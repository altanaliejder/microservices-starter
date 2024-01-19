package com.example.bookservice.dto;

import com.example.bookservice.model.Book;
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

    public static BookDto convert(Book book){
        return BookDto.builder()
                .bookYear(book.getBookYear())
                .author(book.getAuthor())
                .pressName(book.getPressName())
                .title(book.getTitle())
                .id(BookIdDto.convert(book.getId(), book.getIsbn()))
                .build();
    }
}
