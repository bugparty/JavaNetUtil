package com.baidu.wifi.lib.ipdetect.test;

import com.baidu.wifi.lib.ipdetect.model.IPInfo;
import com.baidu.wifi.lib.ipdetect.ip.ISP;
import com.baidu.wifi.lib.ipdetect.netrule.Locate;
import org.junit.Test;

/**
 * Created by hanbowen on 2014/8/19.
 */
public class LocateTest {
    @Test
    public void testConstructor() throws Exception {
        Locate wl = new Locate();
        org.junit.Assert.assertNotNull(wl);

    }

    @Test
    public void testGetInfo() throws Exception {
        Locate wl = new Locate();
        org.junit.Assert.assertNotNull(wl);
        String ip = "222.173.1.2";

        IPInfo di =  wl.getInfo(ip);
        org.junit.Assert.assertEquals(ISP.ChinaTel,di.getIsp());
        org.junit.Assert.assertEquals(ip,di.getIp());

    }
}
