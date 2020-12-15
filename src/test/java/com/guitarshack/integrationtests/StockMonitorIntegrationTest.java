package com.guitarshack.integrationtests;

import com.guitarshack.*;
import com.guitarshack.ProductData;
import com.guitarshack.SalesData;
import org.junit.Test;

import java.util.Calendar;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
