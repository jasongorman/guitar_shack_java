package com.guitarshack.sales;

import com.guitarshack.product.Product;

public class ThirtyDayAverageSalesRate implements SalesRate {
    private final RecentSales recentSales;

    public ThirtyDayAverageSalesRate(RecentSales recentSales) {
        this.recentSales = recentSales;
    }

    @Override
    public double of(Product product) {
        return recentSales.getTotal(product.getId())/30;
    }
}
