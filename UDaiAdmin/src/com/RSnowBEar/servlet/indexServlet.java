package com.RSnowBEar.servlet;

import com.RSnowBEar.dao.adminDao;
import com.RSnowBEar.dao.impl.adminDaoImpl;
import com.RSnowBEar.entity.Administrator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("adminName");
        String adminPassword = request.getParameter("adminPassword");
        adminDao ad = new adminDaoImpl();
        List<Administrator> administrators = ad.selectAdminByNamePwd(new Administrator(adminName, adminPassword));
        administrators.get(0).setIconRealPath(administrators.get(0).getIconRealPath().replace("\\","\\\\"));
        administrators.get(0).setIconRelativePath("../"+administrators.get(0).getIconRelativePath());
        HttpSession session = request.getSession();
        session.setAttribute("admin", administrators.get(0));
        response.sendRedirect("jsp/all-admin-index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
