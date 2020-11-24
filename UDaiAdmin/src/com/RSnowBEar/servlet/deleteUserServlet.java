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
import java.util.List;

@WebServlet("/deleteUserServlet")
public class deleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryString = request.getQueryString();
        userService us = new userServiceImpl();
        if(queryString!=null){
            String substring = queryString.substring(queryString.lastIndexOf("=") + 1);
            List<User> users = us.queryUserByID(new User(Long.parseLong(substring)));
            request.setAttribute("user", users.get(0));
        }else{
            String userId = request.getParameter("userId");
            userId = userId==null?""+0:userId.equals("")?""+0:userId;
            String phone = request.getParameter("phone");
            phone = phone==null?null:phone.equals("")?null:phone;
            User user = new User();
            user.setUserId(userId==null?0:Long.parseLong(userId));
            user.setPhone(phone);
            List<User> users = us.queryUserByID(user);
            request.setAttribute("user",users.size()>0?users.get(0):null);
            request.setAttribute("first",false);
        }
        request.getRequestDispatcher("jsp/user-delete-all.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
