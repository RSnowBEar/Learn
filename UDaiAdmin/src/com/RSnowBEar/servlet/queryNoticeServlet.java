package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.Noticewarehouse;
import com.RSnowBEar.entity.Product;
import com.RSnowBEar.entity.pageBean;
import com.RSnowBEar.service.impl.noticeServiceImpl;
import com.RSnowBEar.service.impl.productServiceImpl;
import com.RSnowBEar.service.noticeService;
import com.RSnowBEar.service.productService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/queryNoticeServlet")
public class queryNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        noticeService ns = new noticeServiceImpl();
        pageBean<Noticewarehouse> pageBean = ns.queryLimit(currentPage, rows);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("jsp/notice-query-all.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
