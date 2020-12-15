package com.guitarshack.unittests;

import com.guitarshack.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReorderLevelTest {

    @Test
    public void reorderLevelIsRateOfSalesMultipliedByLeadTime() {
        SalesRate salesRate = product -> 10.0;
        ReorderLevel reorderLevel = new LeadTimeReorderLevel(salesRate);
        Product product = new Product(811, 10, 14);
        assertEquals(140, reorderLevel.calculate(product));
    }
}
