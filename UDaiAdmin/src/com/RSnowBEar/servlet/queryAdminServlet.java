package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.Administrator;
import com.RSnowBEar.entity.Noticewarehouse;
import com.RSnowBEar.entity.pageBean;
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

@WebServlet("/queryAdminServlet")
public class queryAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        adminService as = new adminServiceImpl();
        pageBean<Administrator> pageBean = as.queryLimit(currentPage, rows);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("jsp/admin-query-all.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
