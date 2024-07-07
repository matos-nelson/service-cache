package com.cache.demo.service_cache.api.service;

import com.cache.demo.service_cache.api.persistence.model.Book;
import com.cache.demo.service_cache.api.persistence.repository.BookRepository;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "book")
@Cacheable
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final IMap<Long, Book> bookMap;

    @Autowired
    public BookService(BookRepository bookRepository, HazelcastInstance cache) {
        this.bookRepository = bookRepository;
        this.bookMap = cache.getMap("book");
    }

    public Long createBook(Book book) {
        log.info("Create Book");
        Book dbBook = bookRepository.save(book);
        bookMap.put(dbBook.getId(), dbBook);
        return dbBook.getId();
    }

    public Book getBook(long id) {
        if (bookMap.containsKey(id)) {
            log.info("Get Book From cache");
            return bookMap.get(id);
        }

        log.info("Get Book From Db");
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            bookMap.put(id, bookOptional.get());
            return bookOptional.get();
        }

        return null;
    }

    public List<Book> getAllBooks() {
        log.info("Get All Book");
        return bookRepository.findAll();
    }
}
