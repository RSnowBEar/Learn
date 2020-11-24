package com.RSnowBEar.log.print;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class adminLogPrinter {
    private Writer writer;
    private StringBuffer sb;

    public boolean printLog(String method,Object obj){
        sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        sb.append(" [信息] ");
        if(method.equals("adminLoginWrong"))
            adminLoginWrong(obj);
        if(method.equals("adminLogin"))
            adminLogin(obj);
        sb.append("\r\n");

        try {
            writer.write(sb.toString());
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean adminLoginWrong(Object obj){
        Map<String,String> map = (HashMap<String,String>)obj;
        sb.append("[管理员登录错误] 错误信息：");
        sb.append("登录用户名="+map.get("adminName"));
        sb.append(",错误密码="+map.get("adminPwd"));
        return false;
    }

    private boolean adminLogin(Object obj){
        Map<String,String> map = (HashMap<String,String>)obj;
        sb.append("[管理员登录] 登录信息：");
        sb.append("登录用户名="+map.get("adminName"));
        return false;
    }

    public adminLogPrinter() {
        try {
            writer = new FileWriter(new File("D:\\Study\\iDealU\\WorkSpace\\UDai\\UDaiAdmin\\src\\com\\RSnowBEar\\log\\logging.txt"),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb = new StringBuffer();
    }

}
