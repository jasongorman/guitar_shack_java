package com.guitarshack.unittests;

import com.guitarshack.product.Product;
import com.guitarshack.sales.RecentSales;
import com.guitarshack.sales.SalesRate;
import com.guitarshack.sales.ThirtyDayAverageSalesRate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class SalesRateTest {

    @Test
    public void salesRateIsAverageDailySalesInLast30Days(){
        RecentSales recentSales = productId -> 300;
        SalesRate salesRate = new ThirtyDayAverageSalesRate(recentSales);
        Product product = new Product(811, 10, 14);
        assertEquals(10.0, salesRate.of(product), 0);
    }
}
