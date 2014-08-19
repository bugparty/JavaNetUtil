package com.baidu.wifi.lib.ipdetect.netrule;

import com.baidu.wifi.lib.ipdetect.model.DnsInfo;

import java.util.ArrayList;

/**
 * Created by hanbowen on 2014/8/19.
 */
public class WhiteList {
    private ArrayList<String> dnsList;
    private Load load;
    public WhiteList() {
        load = new Load("data/ispDnsList/Data", this);
        load.start();
    }
    public DnsInfo getInfo(String ip){
        DnsInfo di = new DnsInfo();
        di.setCountry("中国");
        ip = ip.trim();
        di.setIp(ip);
        di.setIsVerified(false);
        while(load.isAlive()){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){

            }
        }
        for(String s: dnsList){
            if(s.contains(ip)){
                String [] r1,r2;
                r1 = s.split(":");
                r2 = r1[0].split(",");
                di.setIsp(r2[0]);
                di.setProvince(r2[1]);
                di.setIsVerified(true);
            }
        }
        return di;
    }
    private class Load extends Thread{
        private String filename;
        private WhiteList context;


        private Load(String filename, WhiteList context) {
            this.filename = filename;
            this.context = context;

        }

        @Override
        public void run() {
            context.dnsList = Loader.ipList(filename);

        }
    }
}
