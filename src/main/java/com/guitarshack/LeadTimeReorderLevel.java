package com.guitarshack;

import com.guitarshack.product.Product;
import com.guitarshack.sales.SalesRate;

public class LeadTimeReorderLevel implements ReorderLevel {
    private final SalesRate salesRate;

    public LeadTimeReorderLevel(SalesRate salesRate) {
        this.salesRate = salesRate;
    }

    @Override
    public int calculate(Product product) {
        return (int) (salesRate.of(product) * product.getLeadTime());
    }
}
