package com.guitarshack.contracttests;

import com.guitarshack.*;

public class SalesDataContractTest extends SalesDataTestBase {

    @Override
    protected Network getNetwork() {
        return new Web();
    }
}
