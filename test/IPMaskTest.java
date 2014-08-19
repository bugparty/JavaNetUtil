import ip.IPMask;
import ip.IPV4;
import org.junit.Test;

/**
 * Created by hanbowen on 2014/8/18.
 */
public class IPMaskTest {
    @Test
    public void testConstructor1() throws Exception {
        try{
            IPMask ipmask = new IPMask("192.168.1.1/24");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            org.junit.Assert.fail();
        }
        try{
            IPMask ipmask = new IPMask("192.168.1.1","24");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            org.junit.Assert.fail();
        }

    }

    @Test
    public void testGetMask() throws Exception {
        IPMask ipmask;
        try{
            ipmask = new IPMask("192.168.1.1/24");
            org.junit.Assert.assertEquals(24,ipmask.getMask() );
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            org.junit.Assert.fail();
        }
    }

    @Test
    public void testIsIn() throws Exception {
        IPMask ipmask;
        ipmask = new IPMask("192.168.1.1/24");
        IPV4 ip = new IPV4("192.168.1.253");
        org.junit.Assert.assertTrue(ipmask.isIn(ip));
        IPV4 ip2 = new IPV4("192.168.2.253");
        org.junit.Assert.assertFalse(ipmask.isIn(ip2));
        IPMask ipmask2 = new IPMask("222.173.0.0/16");
        IPV4 ip3 = new IPV4("222.173.3.1");
        org.junit.Assert.assertTrue(ipmask2.isIn(ip3));

    }
}
