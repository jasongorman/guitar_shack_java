package com.guitarshack;

import com.guitarshack.*;
import org.junit.Test;

public abstract class ProductDataTestBase {
    @Test
    public void fetchesProductData(){
        Warehouse warehouse = new ProductData(
                new RESTClient(
                        getNetwork(), new RequestBuilder()));
        Product product = warehouse.fetchProduct(811);
    }

    protected abstract Network getNetwork();
}
