package com.example.bookservice;

import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceApplication implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BookServiceApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 =Book.builder().bookYear(2000).title("Dünyanın Gözü").author("Robert Jordan").pressName("55555").isbn("1253156").build();
        Book book2=Book.builder().bookYear(1960).title("Yüzüklerin Efendisi").author("J.R.R Tolkien").pressName("11111").isbn("9862325").build();
        Book book3=Book.builder().bookYear(1997).title("Harry Potter ve Felsefe Taşı").author("J.K Rowling").pressName("88888").isbn("63554").build();

        List<Book> bookList=bookRepository.saveAll(Arrays.asList(book1,book2,book3));
    }
}
