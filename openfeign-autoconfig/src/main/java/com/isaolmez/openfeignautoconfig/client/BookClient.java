package com.isaolmez.openfeignautoconfig.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "books",
        url = "http://localhost:8080/api/books",
        configuration = ClientConfiguration.class)
public interface BookClient {

    @GetMapping(path = "/{isbn}")
    Book findByIsbn(@PathVariable("isbn") String isbn);

    @GetMapping(path = "")
    List<Book> findAll();

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    void create(Book book);
}