package com.guitarshack.unittests;

import com.guitarshack.*;
import com.guitarshack.product.Product;
import com.guitarshack.product.Warehouse;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class StockMonitorTest {

    @Test
    public void alertSentWhenProductNeedsReordering() {
        Alert alert = mock(Alert.class);
        ReorderLevel reorderLevel = product1 -> 10;
        Product product = new Product(811, 11, 14);

        Warehouse warehouse = productId -> product;
        StockMonitor monitor = new StockMonitor(alert, warehouse, reorderLevel);
        monitor.productSold(811, 1);
        verify(alert).send(product);
    }
}
