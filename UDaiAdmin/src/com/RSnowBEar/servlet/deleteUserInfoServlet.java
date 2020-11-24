package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.User;
import com.RSnowBEar.service.impl.userServiceImpl;
import com.RSnowBEar.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUserInfoServlet")
public class deleteUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userID = Integer.parseInt(request.getParameter("userID"));
        userService us = new userServiceImpl();
        boolean b = us.deleteUserByID(new User((Long.valueOf(userID))));
        request.getRequestDispatcher("/queryUserAllServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
