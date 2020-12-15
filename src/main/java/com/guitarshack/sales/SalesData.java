package com.guitarshack.sales;

import com.guitarshack.net.Client;
import com.guitarshack.date.Today;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class SalesData implements RecentSales {
    private final Client client;
    private Today today;

    public SalesData(Client client, Today today) {
        this.client = client;
        this.today = today;
    }

    @Override
    public int getTotal(int productId) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today.date());
        Date endDate = calendar.getTime();
        calendar.add(Calendar.DATE, -30);
        Date startDate = calendar.getTime();
        DateFormat format = new SimpleDateFormat("M/d/yyyy");
        Map<String, Object> params = new HashMap<>(){{
            put("productId", productId);
            put("startDate", format.format(startDate));
            put("endDate", format.format(endDate));
            put("action", "total");
        }};
        SalesTotal total = client.fetchObject(SalesTotal.class,"https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales", params);
        return total.getTotal();
    }
}
