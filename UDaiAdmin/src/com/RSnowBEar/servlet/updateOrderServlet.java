package com.RSnowBEar.servlet;

import com.RSnowBEar.service.impl.orderServiceImpl;
import com.RSnowBEar.service.orderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateOrderServlet")
public class updateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        orderService os = new orderServiceImpl();
        String queryString = request.getQueryString();
        if(queryString!=null){
            String orderId = queryString.substring(queryString.lastIndexOf("=") + 1);
            int i=5,j=1;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
