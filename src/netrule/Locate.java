package netrule;

import ip.IPMask;
import ip.IPV4;
import model.DnsInfo;
import model.IPInfo;
import model.ISP;

import java.util.ArrayList;

/**
 * Created by hanbowen on 2014/8/19.
 */
public class Locate {



    private ArrayList<IPMask> cmccList = new ArrayList<IPMask>(2000);
    private ArrayList<IPMask> cttList = new ArrayList<IPMask>(100);
    private ArrayList<IPMask> chinaTelList = new ArrayList<IPMask>(100);

    private Load cmccLoader,cttLoader,chinaTelLoader;
    public Locate() {
        cmccLoader = new Load("data/ispZoneInfo/CMCC.txt", cmccList);
        cttLoader = new Load("data/ispZoneInfo/CTT.txt", cttList);
        chinaTelLoader = new Load("data/ispZoneInfo/ChinaTelcom.txt", chinaTelList);
        cmccLoader.start();
        cttLoader.start();
        chinaTelLoader.start();
    }
    public IPInfo getInfo(String ip){
        IPInfo ii = new IPInfo();
        IPV4 ipv4 = new IPV4(ip);
        ip = ip.trim();
        ii.setIp(ip);
        ii.setIsp(ISP.UNKNOWN);

        while(cmccLoader.isAlive() || cttLoader.isAlive() || chinaTelLoader.isAlive()){
            try{
                Thread.sleep(50);
            }catch (InterruptedException e){

            }
        }
        boolean found = false;
        for(IPMask s: cmccList){
            if(s.isIn(ipv4)){
               ii.setIsp(ISP.CMCC);
                found = true;
            }
        }
        if(!found){
            for(IPMask s: cttList){
                if(s.isIn(ipv4)){
                    ii.setIsp(ISP.CTT);
                    found = true;
                }
            }
        }
        if(!found){
            for(IPMask s: chinaTelList){
                if(s.isIn(ipv4)){
                    ii.setIsp(ISP.ChinaTel);
                    found = true;
                }
            }
        }
        return ii;
    }
    private class Load extends Thread {
        private String filename;
        private Locate context;
        private ArrayList<String> list;
        private ArrayList<IPMask> maskList = new ArrayList<IPMask>(500);


        private Load(String filename, ArrayList<IPMask> ipMasks) {
            this.filename = filename;
            this.maskList = ipMasks;

        }

        @Override
        public void run() {
            list = Loader.ipMask(filename);
            for(String s : list){
                maskList.add(new IPMask(s));
            }
        }
    }
}
