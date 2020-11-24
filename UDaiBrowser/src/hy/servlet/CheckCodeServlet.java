package hy.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            画图片
                1.属性：宽、高
                2.图片对象
                3.画笔（设置颜色）
                4.画内容（内容、干扰线）
                5.将图片通过响应对象响应给客户端
         */
        int width = 100;
        int height = 30;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics g = image.getGraphics();
        //给笔上色
        Random ra = new Random();
        g.setColor(new Color(ra.nextInt(256),ra.nextInt(256),ra.nextInt(256)));
        //开始画
        g.fillRect(0,0,width,height);
        //随机产生验证码
        String s = randomCode();
        //把产生的验证码放到上下文对象上
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("s",s);

        g.setFont(new Font("楷体",Font.ITALIC,25));
        g.setColor(new Color(ra.nextInt(256),ra.nextInt(256),ra.nextInt(256)));
        g.drawString(s,20,20);

        g.setColor(new Color(ra.nextInt(256),ra.nextInt(256),ra.nextInt(256)));

        for (int i = 0; i <10 ; i++) {
            g.drawLine(ra.nextInt(100),ra.nextInt(30),ra.nextInt(100),ra.nextInt(30));
        }
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    public String randomCode(){
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        for(int count=0;count<=3;count++) {
            int i = r.nextInt(3);
            switch(i){
                case 0:
                    int j = r.nextInt(10);
                    sb.append(j);
                    break;
                case 1:
                    char ch = (char)(r.nextInt(26)+65);
                    sb.append(ch);
                    break;
                case 2:
                    char ch1 = (char)(r.nextInt(26)+97);
                    sb.append(ch1);
                    break;
            }
        }
        return new String(sb);
    }
}
