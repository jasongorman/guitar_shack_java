package com.guitarshack;

import com.guitarshack.net.Network;
import com.guitarshack.net.RESTClient;
import com.guitarshack.net.RequestBuilder;
import com.guitarshack.product.Product;
import com.guitarshack.product.ProductData;
import com.guitarshack.product.Warehouse;
import org.junit.Test;

/*

    This Abstract Test allows us to create two versions of the set-up, one with
    stubbed JSON and one that actually connects to the web service, effectively pinpointing
    whether an error has occurred because of a change to our code or a change to the external dependency

 */

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
