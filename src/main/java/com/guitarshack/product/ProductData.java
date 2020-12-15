package com.guitarshack.product;

import com.guitarshack.net.Client;

import java.util.HashMap;
import java.util.Map;

public class ProductData implements Warehouse {
    private final Client client;

    public ProductData(Client client) {
        this.client = client;
    }

    @Override
    public Product fetchProduct(int productId) {
        String baseURL = "https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/product";
        Map<String, Object> params = new HashMap<>() {{
            put("id", productId);
        }};
        return client.fetchObject(Product.class, baseURL, params);
    }
}
