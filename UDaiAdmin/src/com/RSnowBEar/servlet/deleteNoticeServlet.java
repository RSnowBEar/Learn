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

@WebServlet("/deleteNoticeServlet")
public class deleteNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long noticeID = Long.valueOf(request.getParameter("noticeId"));
        noticeService ns = new noticeServiceImpl();
        boolean b = ns.deleteNotice(new Noticewarehouse(noticeID));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
