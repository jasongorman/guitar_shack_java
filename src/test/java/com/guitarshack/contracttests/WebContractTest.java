package com.guitarshack.contracttests;

import com.guitarshack.Web;
import org.junit.Test;

import java.net.URI;
import java.net.http.HttpRequest;

import static org.junit.Assert.assertTrue;

public class WebContractTest {

    @Test
    public void getTestCoverageTo100Percent() {
        Web web = new Web();
        HttpRequest request = HttpRequest
                .newBuilder(URI.create("http://www.codemanship.com"))
                .build();

        assertTrue(web.fetchJson(request).length() > 0);
    }
}
