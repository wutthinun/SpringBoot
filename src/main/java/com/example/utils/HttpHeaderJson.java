package com.example.utils;

import org.springframework.http.HttpHeaders;

/**
 * Created by wutthinan on 4/4/2016 AD.
 */
public class HttpHeaderJson {
    public static HttpHeaders getJsonHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/json;charset=urf-8");
        return headers;
    }
}
