package com.isaolmez.openfeignautoconfig.client;

import feign.RequestTemplate;
import feign.auth.BasicAuthRequestInterceptor;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

@Slf4j
public class LoggingBasicAuthRequestInterceptor extends BasicAuthRequestInterceptor {
    public LoggingBasicAuthRequestInterceptor(String username, String password) {
        super(username, password);
    }

    public LoggingBasicAuthRequestInterceptor(String username, String password, Charset charset) {
        super(username, password, charset);
    }

    @Override
    public void apply(RequestTemplate template) {
        log.info("Applying basic auth to the request.");
        super.apply(template);
    }
}
