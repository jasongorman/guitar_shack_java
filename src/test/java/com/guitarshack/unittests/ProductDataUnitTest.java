package com.guitarshack.unittests;

import com.guitarshack.*;
import com.guitarshack.net.Network;

public class ProductDataUnitTest extends ProductDataTestBase {

    @Override
    protected Network getNetwork() {
        return request -> "{\"id\":811,\"make\":\"Epiphone\",\"range\":\"Les Paul\",\"model\":\"Les Paul Classic\",\"description\":\"Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst\",\"price\":399,\"stock\":53,\"rackspace\":30,\"leadTime\":14,\"minOrder\":20}";
    }
}
