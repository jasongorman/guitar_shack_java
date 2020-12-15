package com.guitarshack;

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
