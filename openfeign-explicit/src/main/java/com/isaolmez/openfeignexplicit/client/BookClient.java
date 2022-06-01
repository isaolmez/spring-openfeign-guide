package com.isaolmez.openfeignexplicit.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface BookClient {
    @RequestLine("GET /{isbn}")
    Book findByIsbn(@Param("isbn") String isbn);

    @RequestLine("GET")
    List<Book> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(Book book);
}