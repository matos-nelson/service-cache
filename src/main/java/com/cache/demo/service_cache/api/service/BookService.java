package com.cache.demo.service_cache.api.service;

import com.cache.demo.service_cache.api.persistence.model.Book;
import com.cache.demo.service_cache.api.persistence.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Long createBook(Book book) {
        Book dbBook = bookRepository.save(book);
        return dbBook.getId();
    }

    public Book getBook(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
