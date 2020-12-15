package com.guitarshack.unittests;

import com.guitarshack.net.Network;
import com.guitarshack.SalesDataTestBase;

public class SalesDataUnitTest extends SalesDataTestBase {
    @Override
    protected Network getNetwork() {
        return request -> "{\"productID\":811,\"startDate\":\"7/17/2019\",\"endDate\":\"7/27/2019\",\"total\":31}";
    }
}
