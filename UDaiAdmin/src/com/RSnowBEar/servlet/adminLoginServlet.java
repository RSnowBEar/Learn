package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.Administrator;
import com.RSnowBEar.log.print.adminLogPrinter;
import com.RSnowBEar.service.adminService;
import com.RSnowBEar.service.impl.adminServiceImpl;
import com.RSnowBEar.util.jsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/adminLoginServlet")
public class adminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        jsonReader jr = new jsonReader();
        Administrator admin = (Administrator)jr.getMessage(request,Administrator.class);
        ObjectMapper mapper = new ObjectMapper();
        adminService as = new adminServiceImpl();
        Map<String,String> map = new HashMap<>();
        map.put("adminName", admin.getAdminName());
        map.put("adminPwd", admin.getAdminPassword());
        adminLogPrinter alp = new adminLogPrinter();
        if(as.adminLogin(admin)){
            map.put("ff", "true");
            alp.printLog("adminLogin", map);
        }else{
            map.put("ff", "false");
            alp.printLog("adminLoginWrong", map);
        }
        mapper.writeValue(response.getOutputStream(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
