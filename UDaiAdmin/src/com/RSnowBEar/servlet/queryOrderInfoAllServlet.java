package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.OrderDetailInfo;
import com.RSnowBEar.entity.Product;
import com.RSnowBEar.entity.pageBean;
import com.RSnowBEar.service.impl.orderServiceImpl;
import com.RSnowBEar.service.impl.productServiceImpl;
import com.RSnowBEar.service.orderService;
import com.RSnowBEar.service.productService;
import com.RSnowBEar.util.skuUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryOrderInfoAllServlet")
public class queryOrderInfoAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        orderService os = new orderServiceImpl();
        pageBean<OrderDetailInfo> pageBean = os.queryLimit(currentPage, rows);
        List<OrderDetailInfo> list = pageBean.getList();
        for (OrderDetailInfo order : list) {
            order.setSkuAttribute(skuUtil.getSkuMap((String)order.getSkuAttribute()));
        }

        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("jsp/order-query-all.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
