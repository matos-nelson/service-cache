package com.cache.demo.service_cache.api.controller;

import com.cache.demo.service_cache.api.persistence.model.Book;
import com.cache.demo.service_cache.api.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public @ResponseBody Long saveBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Book getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @GetMapping
    public @ResponseBody List<Book> getBooks() {
        return bookService.getAllBooks();
    }
}
