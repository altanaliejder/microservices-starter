package com.example.libraryservice.service;

import com.example.libraryservice.client.BookServiceClient;
import com.example.libraryservice.dto.AddBookRequest;
import com.example.libraryservice.dto.LibraryDto;
import com.example.libraryservice.exception.LibraryNotFoundException;
import com.example.libraryservice.model.Library;
import com.example.libraryservice.repository.LibraryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }
    public LibraryDto getAllBooksInLibraryById(String id){
        Library library=libraryRepository.findById(id)
                .orElseThrow(()->new LibraryNotFoundException("Library could not found by book id"));
        LibraryDto libraryDto =LibraryDto.builder().id(library.getId())
                .userBooksList(library.getUserBooks()
                        .stream()
                        .map(bookServiceClient::getBookById)
                        .map(ResponseEntity::getBody)
                        .toList())
                .build();
        return libraryDto;
    }

    public LibraryDto createLibrary(){
        Library newLibrary=libraryRepository.save(new Library());
        return LibraryDto.builder().id(newLibrary.getId()).build();
    }

    public void addBookToLibrary(AddBookRequest request){
        String bookId=bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getId();
        Library library=libraryRepository.findById(request.getId())
                .orElseThrow(()->new LibraryNotFoundException("Library not found"));

        library.getUserBooks().add(bookId);
        libraryRepository.save(library);
    }
}
