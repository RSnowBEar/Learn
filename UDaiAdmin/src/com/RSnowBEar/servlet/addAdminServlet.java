package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.Administrator;
import com.RSnowBEar.entity.Noticewarehouse;
import com.RSnowBEar.service.adminService;
import com.RSnowBEar.service.impl.adminServiceImpl;
import com.RSnowBEar.service.impl.noticeServiceImpl;
import com.RSnowBEar.service.noticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@MultipartConfig
@WebServlet("/addAdminServlet")
public class addAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Administrator a = new Administrator();
        String adminName = request.getParameter("adminName");
        a.setAdminName(adminName);
        String adminPassword = request.getParameter("adminPassword");
        a.setAdminPassword(adminPassword);
        HttpSession session = request.getSession();
        Administrator admin1 = (Administrator)session.getAttribute("admin");
        Integer pid = (int)(long)admin1.getAdminId();
        a.setPid(pid);

        Part adminIcon = request.getPart("adminIcon");
        String relativePath = "img/";
        String realPath = request.getServletContext().getRealPath(relativePath);
        String fileName = adminIcon.getSubmittedFileName();
        fileName = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
        a.setIconRelativePath(relativePath+fileName);
        a.setIconRealPath(realPath+fileName);
        adminIcon.write(realPath+fileName);

        adminService as = new adminServiceImpl();
        boolean b = as.addAdmin(a);
        request.getRequestDispatcher("/queryAdminServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
