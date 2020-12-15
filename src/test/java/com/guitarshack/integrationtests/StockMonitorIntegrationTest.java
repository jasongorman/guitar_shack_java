package com.guitarshack.integrationtests;

import com.guitarshack.*;
import com.guitarshack.net.RESTClient;
import com.guitarshack.net.RequestBuilder;
import com.guitarshack.net.Web;
import com.guitarshack.product.ProductData;
import com.guitarshack.sales.SalesData;
import com.guitarshack.sales.ThirtyDayAverageSalesRate;
import org.junit.Test;

import java.util.Calendar;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/*

    It's a good idea to have at least one test that wires together most or all
    of the implementations of our interfaces to check that we haven't missed anything

 */

public class StockMonitorIntegrationTest {

    @Test
    public void alertShouldBeTriggered(){
        Alert alert = mock(Alert.class);
        StockMonitor monitor = new StockMonitor(
                alert,
                new ProductData(
                        new RESTClient(
                                new Web(),
                                new RequestBuilder())),
                new LeadTimeReorderLevel(
                        new ThirtyDayAverageSalesRate(
                                new SalesData(
                                        new RESTClient(
                                                new Web(),
                                                new RequestBuilder()
                                        ),
                                        () -> {
                                            Calendar calendar = Calendar.getInstance();
                                            calendar.set(2019, Calendar.AUGUST, 1);
                                            return calendar.getTime();
                                        }
                                )
                        )
                )
        );

        monitor.productSold(811, 40);

        verify(alert).send(any());
    }
}
