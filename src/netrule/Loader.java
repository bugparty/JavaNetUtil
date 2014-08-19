package netrule;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hanbowen on 2014/8/18.
 */
public class Loader {
    public static ArrayList<String> ipList(String fileName) {
        ArrayList<String> list = new ArrayList<String>(500);
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;

            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                if (StringUtils.contains(tempString, ':')) {
                    list.add(tempString);
                }
                else{
                    throw new IllegalArgumentException("DNS info has a bad format,line is "+tempString);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    return list;
    }
    public static ArrayList<String> ipMask(String fileName) {
        ArrayList<String> list = new ArrayList<String>(500);
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;

            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                if (tempString.startsWith(";"))
                    continue;
                if (tempString.endsWith(";")) {
                    tempString = tempString.substring(0,tempString.length()-1);
                    list.add(tempString);

                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return list;
    }
}
