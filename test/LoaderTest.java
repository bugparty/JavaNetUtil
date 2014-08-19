import netrule.Loader;
import org.junit.Test;

import java.util.ArrayList;

public class LoaderTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void testipMask() throws Exception {
        String f1 = "data/ispZoneInfo/ChinaTelcom.txt";
        String f2 = "data/ispZoneInfo/CMCC.txt";
        String f3 = "data/ispZoneInfo/CTT.txt";
        ArrayList<String> list;
        list = Loader.ipMask(f1);
        org.junit.Assert.assertTrue(list.size() != 0);

        System.out.println("Loader loaded "+list.size()+" rules");
        list = Loader.ipMask(f2);
        org.junit.Assert.assertTrue(list.size() != 0);
        System.out.println("Loader loaded "+list.size()+" rules");
        list = Loader.ipMask(f3);
        org.junit.Assert.assertTrue(list.size() != 0);
        System.out.println("Loader loaded "+list.size()+" rules");


    }

    @Test
    public void testIpList() throws Exception {
        String f1 = "data/ispDnsList/Data";
        ArrayList<String> list;
        list = Loader.ipList(f1);
        org.junit.Assert.assertTrue(list.size() != 0);

    }
}