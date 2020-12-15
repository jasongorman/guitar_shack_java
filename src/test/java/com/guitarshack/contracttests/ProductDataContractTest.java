package com.guitarshack.contracttests;

import com.guitarshack.net.Network;
import com.guitarshack.ProductDataTestBase;
import com.guitarshack.net.Web;

/*

    If this test fails when the ProductDataUnitTest is still passing, this indicates a change
    in the external API

 */

public class ProductDataContractTest extends ProductDataTestBase {
    @Override
    protected Network getNetwork() {
        return new Web();
    }
}
