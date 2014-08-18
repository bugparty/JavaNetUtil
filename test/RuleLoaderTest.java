import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RuleLoaderTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void testipList() throws Exception {
        String f1 = "data/ChinaTelcom.txt";
        String f2 = "data/CMCC.txt";
        String f3 = "data/CTT.txt";
        ArrayList<String> list;
        list = RuleLoader.ipList(f1);
        org.junit.Assert.assertNotNull(list);

        System.out.println("loaded "+list.size()+" rules");
        list = RuleLoader.ipList(f2);
        org.junit.Assert.assertNotNull(list);
        System.out.println("loaded "+list.size()+" rules");
        list = RuleLoader.ipList(f3);
        org.junit.Assert.assertNotNull(list);
        System.out.println("loaded "+list.size()+" rules");


    }
}