package com.test;

import com.entity.record;
import com.entity.selectRecord;
import com.entity.user;
import com.service.serviceImpl.adminServiceImpl;
import com.service.serviceImpl.userServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        userServiceImpl usi = new userServiceImpl();
        adminServiceImpl asi = new adminServiceImpl();
        Map hashMap = new HashMap();
        hashMap.put("adminName","a");
        hashMap.put("car_num","b");
        hashMap.put("brand_id",1);
        hashMap.put("model","c");
        hashMap.put("color","d");
        hashMap.put("category_id", 1);
        hashMap.put("comments", "e");
        hashMap.put("price","1000.2");
        hashMap.put("rent","100asdasdasd");
        hashMap.put("status",0);
        hashMap.put("useable",0);
        Object o = hashMap;
        Map data = (HashMap) o;

        System.out.println(
        (String) data.get("car_num")+
                Integer.parseInt(String.valueOf(data.get("brand_id")))+
                (String) data.get("model")+
                (String) data.get("color")+
                Integer.parseInt(String.valueOf(data.get("category_id")))+
                (String) data.get("comments")+
                Float.parseFloat(String.valueOf(data.get("price")))+
                Float.parseFloat(String.valueOf(data.get("rent")))+
                Integer.parseInt(String.valueOf(data.get("status")))+
                Integer.parseInt(String.valueOf(data.get("useable")))
        );
    }

    private static void show(Integer id){
        System.out.println(id);
    }
}
