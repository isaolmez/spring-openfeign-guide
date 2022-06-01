package com.isaolmez.openfeignautoconfig.client.logrequest;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

@Slf4j
public class RequestLoggingDecoder implements Decoder {

    private final Decoder delegate;

    public RequestLoggingDecoder(Decoder delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        logRequest(response);
        return delegate.decode(response, type);
    }

    private void logRequest(Response response) {
        log.info("Url: {}", response.request().url());
        log.info("Response code: {}", response.status());
        log.info("Response reason: {}", response.reason());
        log.info("Request as json: {}", toString(response.request().body(), response.request().charset()));
        try {
            // Input stream is consumed, so not works!
            log.info("Response as json: {}", IOUtils.toString(response.body().asInputStream()));
            log.info("Response as json: {}", IOUtils.toString(response.body().asInputStream()));
        } catch (IOException e) {
            log.error("Error occurred.", e);
        }
    }

    private String toString(byte[] data, Charset charset) {
        if (data == null) {
            return null;
        }

        return new String(data, charset);
    }
}
