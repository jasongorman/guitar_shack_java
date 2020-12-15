package com.guitarshack;

import java.io.IOException;
import java.net.http.HttpRequest;

public interface Network {
    String fetchJson(HttpRequest request);
}
