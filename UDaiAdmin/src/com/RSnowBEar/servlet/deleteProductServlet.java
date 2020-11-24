package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.Product;
import com.RSnowBEar.service.impl.productServiceImpl;
import com.RSnowBEar.service.productService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteProductServlet")
public class deleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productID = Long.valueOf(request.getParameter("productId"));
        productService ps = new productServiceImpl();
        boolean b = ps.deleteProduct(new Product(productID));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
