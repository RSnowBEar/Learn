package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.Administrator;
import com.RSnowBEar.entity.Noticewarehouse;
import com.RSnowBEar.service.adminService;
import com.RSnowBEar.service.impl.adminServiceImpl;
import com.RSnowBEar.service.impl.noticeServiceImpl;
import com.RSnowBEar.service.noticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAdminServlet")
public class deleteAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long adminId = Long.valueOf(request.getParameter("adminId"));
        adminService as = new adminServiceImpl();
        boolean b = as.delAdmin(new Administrator(adminId));
        request.getRequestDispatcher("queryAdminServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
