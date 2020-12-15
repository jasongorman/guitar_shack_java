package com.guitarshack;

import com.guitarshack.product.Product;
import com.guitarshack.product.Warehouse;

public class StockMonitor {
    private final Alert alert;
    private final Warehouse warehouse;
    private final ReorderLevel reorderLevel;

    public StockMonitor(Alert alert, Warehouse warehouse, ReorderLevel reorderLevel) {
        this.alert = alert;
        this.warehouse = warehouse;
        this.reorderLevel = reorderLevel;
    }

    public void productSold(int productId, int quantity) {
        Product product = warehouse.fetchProduct(productId);
        if(needsReordering(product, quantity))
            alert.send(product);
    }

    private Boolean needsReordering(Product product, int quantitySold) {
        return product.getStock() - quantitySold <= reorderLevel.calculate(product);
    }
}
