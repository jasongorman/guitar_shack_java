package com.guitarshack;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertTrue;

public abstract class SalesDataTestBase {
    @Test
    public void fetchesSalesData(){
        SalesData salesData = new SalesData(new RESTClient(getNetwork(), new RequestBuilder()), () -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2019, Calendar.JANUARY, 31);
            return calendar.getTime();
        });
        int total = salesData.getTotal(811);
        assertTrue(total > 0);
    }

    protected abstract Network getNetwork();
}
