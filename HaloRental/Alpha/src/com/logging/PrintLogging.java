package com.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintLogging {
    private static FileWriter fw;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void outputLogging(String userName,String function){
        try {
            fw = new FileWriter("Alpha\\src\\com\\logging\\logging.txt",true);
            StringBuffer log = new StringBuffer();
            log.append(sdf.format(new Date()));
            log.append(" —— [");
            log.append(userName);
            log.append("] \t");
            log.append(function);
            log.append("\r\n");
            fw.write(new String(log));
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
