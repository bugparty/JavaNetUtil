package com.baidu.wifi.lib.ipdetect.test;

import com.baidu.wifi.lib.ipdetect.model.DnsInfo;
import com.baidu.wifi.lib.ipdetect.netrule.WhiteList;
import org.junit.Test;

/**
 * Created by hanbowen on 2014/8/19.
 */
public class WhiteListTest {
    @Test
    public void testConstructor() throws Exception {
        WhiteList wl = new WhiteList();
        org.junit.Assert.assertNotNull(wl);

    }

    @Test
    public void testGetInfo() throws Exception {
        WhiteList wl = new WhiteList();
        org.junit.Assert.assertNotNull(wl);
        String ip = "61.128.97.73";
        String isp = "铁通";
        String province = "新疆";
        DnsInfo di =  wl.getInfo(ip);
        org.junit.Assert.assertEquals(isp,di.getIsp());
        org.junit.Assert.assertEquals(province,di.getProvince());
        org.junit.Assert.assertEquals(ip,di.getIp());
        org.junit.Assert.assertEquals("中国",di.getCountry());
        org.junit.Assert.assertEquals(true, di.getIsVerified());
    }
}
