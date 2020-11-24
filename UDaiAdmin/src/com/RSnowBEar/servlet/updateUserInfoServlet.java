package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.User;
import com.RSnowBEar.service.impl.userServiceImpl;
import com.RSnowBEar.service.userService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@MultipartConfig
@WebServlet("/updateUserInfoServlet")
public class updateUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService us = new userServiceImpl();
        User user = new User();
        //获取表中数据
        Long userID = Long.parseLong(request.getParameter("userID"));
        user.setUserId(userID);
        Integer gander = Integer.parseInt(request.getParameter("gander"));
        user.setGander(gander);
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        user.setBirthday(birthday);
        String nickName = request.getParameter("nickName");
        user.setNickName(nickName);
        Double balance = Double.parseDouble(request.getParameter("balance"));
        user.setBalance(balance);
        Integer integral = Integer.parseInt(request.getParameter("integral"));
        user.setIntegral(integral);
        Integer memberLevel = Integer.parseInt(request.getParameter("memberLevel"));
        user.setMemberLevel(memberLevel);

        //获取表中头像
        Part icon = request.getPart("icon");
        System.out.println(icon.getSubmittedFileName());
        //要更新头像
        if(icon!=null && icon.getSubmittedFileName()!=""){
            User tempUser = us.queryUserByID(new User(userID)).get(0);
            //要更新的路径
            String path = "img/";
            String fileName = UUID.randomUUID().toString()+icon.getSubmittedFileName().substring(icon.getSubmittedFileName().lastIndexOf("."));
            String realPath = request.getServletContext().getRealPath(path)+fileName;
            user.setIconRealPath(realPath);
            String relativePath = path+fileName;
            user.setIconRelativePath(relativePath);
            //原来的头像路径
            String iconRelativePath = tempUser.getIconRelativePath();

            //删除原来的头像
            File file = new File(iconRelativePath);
            if(file.exists()){
                file.delete();
            }
            //存入新的头像
//            System.out.println(realPath);
            icon.write(realPath);
        }
        boolean b = us.modifyUserInfo(user);
        request.getRequestDispatcher("/queryUserAllServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
