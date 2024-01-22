package com.example.libraryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
    private ExceptionMessage message;
    public BookNotFoundException(String message) {
        super(message);
    }
    public BookNotFoundException(ExceptionMessage message){
        this.message=message;
    }

    public ExceptionMessage getExceptionMessage(){
        return this.message;
    }
}
