package hy.servlet;

import hy.domain.User;
import hy.service.userServiceImpl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String phone = request.getParameter("phone");//电话
        String password = request.getParameter("password");//密码
        String smscode = request.getParameter("smscode");//输入的验证码
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);

        UserServiceImpl userService = new UserServiceImpl();
        System.out.println("来到了register");

        ServletContext servletContext = this.getServletContext();
        String s = (String)servletContext.getAttribute("s");
        if(smscode==s){
            boolean b = userService.registerUS(user);
            if(b){
                System.out.println("来到了register,b=true");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }else {
                System.out.println("来到了register,b=flase");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }
        else {
            System.out.println("验证码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
