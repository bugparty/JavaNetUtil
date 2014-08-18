import org.junit.Test;

/**
 * Created by hanbowen on 2014/8/18.
 */
public class IPV4Test {
    @Test
    public void testIPV4() throws Exception {
        IPV4 ip = new IPV4("192.168.1.1");
        org.junit.Assert.assertEquals(192, IPV4.byteToUnsignedInt(ip.getB1()));
        org.junit.Assert.assertEquals(168, IPV4.byteToUnsignedInt(ip.getB2()));
        org.junit.Assert.assertEquals(1, IPV4.byteToUnsignedInt(ip.getB3()));
        org.junit.Assert.assertEquals(1, IPV4.byteToUnsignedInt(ip.getB4()));

        String str = IPV4.hex2IPStr(ip.getInt32());

        org.junit.Assert.assertEquals("192.168.1.1", str);


    }

    @Test
    public void testInt32toBytes() throws Exception {
        int hex = 0x01020304;
        byte []b = IPV4.int32toBytes(hex);
        org.junit.Assert.assertTrue(b.length != 0);
        org.junit.Assert.assertEquals(IPV4.byteToUnsignedInt(b[0]) , 0x01);
        org.junit.Assert.assertEquals(IPV4.byteToUnsignedInt(b[1]) , 0x02);
        org.junit.Assert.assertEquals(IPV4.byteToUnsignedInt(b[2]) , 0x03);
        org.junit.Assert.assertEquals(IPV4.byteToUnsignedInt(b[3]) , 0x04);

    }

    @Test
    public void testHex2IPStr() throws Exception {
        int hex = 0xC0A80101;//192.168.1.1
        String str = IPV4.hex2IPStr(hex);

        org.junit.Assert.assertEquals("192.168.1.1", str);


    }
}
