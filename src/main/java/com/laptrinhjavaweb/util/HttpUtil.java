package com.laptrinhjavaweb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {

    private String value;

    public HttpUtil() {

    }

    public HttpUtil(String value) {
        this.setValue(value);
    }

    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static HttpUtil of(BufferedReader reader) {
        String val = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        return new HttpUtil(val);
    }
}
