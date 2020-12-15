package com.guitarshack.net;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.http.HttpRequest;
import java.util.Map;

public class RESTClient implements Client {

    private final Network network;
    private final RequestBuilder requestBuilder;

    public RESTClient(Network network, RequestBuilder requestBuilder) {
        this.network = network;
        this.requestBuilder = requestBuilder;
    }

    @Override
    public <T> T fetchObject(Class<T> type, String baseURL, Map<String, Object> parameters) {
        HttpRequest request = requestBuilder.buildRequest(baseURL, parameters);
        Type typeOfT = new TypeToken<T>(){}.getType();
        return new Gson().fromJson(network.fetchJson(request), type);
    }

}
