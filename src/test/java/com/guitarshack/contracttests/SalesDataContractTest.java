package com.guitarshack.contracttests;

import com.guitarshack.*;
import com.guitarshack.net.Network;
import com.guitarshack.net.Web;

/*

    If this test fails when the SalesDataUnitTest is still passing, this indicates a change
    in the external API

 */

public class SalesDataContractTest extends SalesDataTestBase {

    @Override
    protected Network getNetwork() {
        return new Web();
    }
}
