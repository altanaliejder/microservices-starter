package com.example.libraryservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LibraryDto {
    private String id;
    private List<BookDto> userBooksList;
}
