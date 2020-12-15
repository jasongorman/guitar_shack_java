package com.guitarshack;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;

public class RequestBuilder {
    public RequestBuilder() {
    }

    HttpRequest buildRequest(String baseURL, Map<String, Object> parameters) {
        String paramString = "?";

        for (String key : parameters.keySet()) {
            paramString += key + "=" + parameters.get(key).toString() + "&";
        }
        return HttpRequest
                .newBuilder(URI.create(baseURL + paramString))
                .build();
    }
}