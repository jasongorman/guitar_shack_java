package com.guitarshack.contracttests;

import com.guitarshack.Network;
import com.guitarshack.ProductDataTestBase;
import com.guitarshack.Web;

public class ProductDataContractTest extends ProductDataTestBase {
    @Override
    protected Network getNetwork() {
        return new Web();
    }
}
