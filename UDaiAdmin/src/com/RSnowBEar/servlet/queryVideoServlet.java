package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.Noticewarehouse;
import com.RSnowBEar.entity.Videos;
import com.RSnowBEar.entity.pageBean;
import com.RSnowBEar.service.impl.noticeServiceImpl;
import com.RSnowBEar.service.impl.videoServiceImpl;
import com.RSnowBEar.service.noticeService;
import com.RSnowBEar.service.videoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/queryVideoServlet")
public class queryVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        videoService vs = new videoServiceImpl();
        pageBean<Videos> pageBean = vs.queryLimit(currentPage, rows);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("jsp/video-query-all.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
