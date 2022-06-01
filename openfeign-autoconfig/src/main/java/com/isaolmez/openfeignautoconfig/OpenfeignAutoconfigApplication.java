package com.isaolmez.openfeignautoconfig;

import com.isaolmez.openfeignautoconfig.client.Book;
import com.isaolmez.openfeignautoconfig.client.BookClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Slf4j
@SpringBootApplication
@EnableFeignClients
public class OpenfeignAutoconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignAutoconfigApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(BookClient bookClient) {
        return args -> {
            bookClient.create(Book.builder().name("book1").isbn("1").writer("me").build());
            bookClient.create(Book.builder().name("book2").isbn("2").writer("me").build());
            Book book1 = bookClient.findByIsbn("1");
            log.info("{}", book1);
            List<Book> allBooks = bookClient.findAll();
            log.info("{}", allBooks);
        };
    }
}
