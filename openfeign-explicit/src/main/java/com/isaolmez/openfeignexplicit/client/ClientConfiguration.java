package com.isaolmez.openfeignexplicit.client;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    public BookClient bookClient(){
        return Feign.builder()
                .client(new OkHttpClient())
                .logger(new Slf4jLogger(BookClient.class))
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logLevel(Logger.Level.FULL)
                .target(BookClient.class, "http://localhost:8080/api/books");
    }
}
