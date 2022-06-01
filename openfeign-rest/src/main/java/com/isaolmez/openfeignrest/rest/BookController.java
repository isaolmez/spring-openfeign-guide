package com.isaolmez.openfeignrest.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final Map<String, Book> bookMap = new HashMap<>();

    @GetMapping(path = "/{isbn}")
    public Book getByIsbn(@PathVariable("isbn") String isbn) {
        return bookMap.get(isbn);
    }

    @GetMapping
    public List<Book> getAll() {
        return new ArrayList<>(bookMap.values());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book create(@RequestBody Book book) {
        return bookMap.put(book.getIsbn(), book);
    }
}
