package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.Noticewarehouse;
import com.RSnowBEar.service.impl.noticeServiceImpl;
import com.RSnowBEar.service.noticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addNoticeServlet")
public class addNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long type = Long.valueOf(request.getParameter("type"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Noticewarehouse notice = new Noticewarehouse(type, title, content);
        noticeService ns = new noticeServiceImpl();
        boolean b = ns.addNotice(notice);
        request.getRequestDispatcher("/queryNoticeServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
