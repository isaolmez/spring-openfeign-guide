package com.isaolmez.openfeignautoconfig.client;

import feign.RequestInterceptor;
import feign.Retryer;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class ClientConfiguration {

    @Bean
    public Retryer retryer(){
        return new Retryer.Default(100, 3000, 5);
    }

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

//    @Bean
//    public RequestLoggingDecoder requestLoggingDecoder(FeignClientsConfiguration feignClientsConfiguration) {
//        return new RequestLoggingDecoder(feignClientsConfiguration.feignDecoder());
//    }

    @Bean
    public RequestInterceptor basicAuthenticationRequestInterceptor() {
        return new LoggingBasicAuthRequestInterceptor("test", "test");
    }
}
