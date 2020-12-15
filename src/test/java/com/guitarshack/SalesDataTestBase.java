package com.guitarshack;

import com.guitarshack.net.Network;
import com.guitarshack.net.RESTClient;
import com.guitarshack.net.RequestBuilder;
import com.guitarshack.sales.SalesData;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertTrue;

/*

    This Abstract Test allows us to create two versions of the set-up, one with
    stubbed JSON and one that actually connects to the web service, effectively pinpointing
    whether an error has occurred because of a change to our code or a change to the external dependency

 */

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
