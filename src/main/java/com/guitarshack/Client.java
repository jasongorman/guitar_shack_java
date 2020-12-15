package com.guitarshack;

import java.util.List;
import java.util.Map;

public interface Client {

    <T> T fetchObject(Class<T> type, String baseURL, Map<String, Object> parameters);
}
