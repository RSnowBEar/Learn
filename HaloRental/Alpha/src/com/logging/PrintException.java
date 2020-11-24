package com.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintException {
    private static FileWriter fw;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void outputException(Exception e, Socket socket){
        try {
            fw = new FileWriter("Alpha\\src\\com\\logging\\exceptionLog.txt",true);
            StringBuffer log = new StringBuffer();
            log.append(sdf.format(new Date()));
            log.append("——");
            log.append(e.getClass());
            log.append(":\t");
            log.append(socket.getInetAddress().getHostAddress());
            log.append("\t");
            log.append(e.getMessage());
            log.append("\r\n");
            fw.write(new String(log));
            fw.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
