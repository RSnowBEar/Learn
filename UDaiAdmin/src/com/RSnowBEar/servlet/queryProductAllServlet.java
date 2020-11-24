package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.Product;
import com.RSnowBEar.entity.User;
import com.RSnowBEar.entity.pageBean;
import com.RSnowBEar.service.impl.productServiceImpl;
import com.RSnowBEar.service.impl.userServiceImpl;
import com.RSnowBEar.service.productService;
import com.RSnowBEar.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/queryProductAllServlet")
public class queryProductAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        productService ps = new productServiceImpl();
        pageBean<Product> pageBean = ps.queryLimit(currentPage, rows);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("jsp/product-query-all.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
