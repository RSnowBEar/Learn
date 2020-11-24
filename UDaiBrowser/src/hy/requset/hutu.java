package hy.requset;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/hutu")
public class hutu extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width=150;
        int height=100;
        //获取一个画图对象
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        //获取画笔
        Graphics g = img.getGraphics();
        //给画笔一个随机颜色
        Random ran = new Random();
        g.setColor(new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256)));
        g.fillRect(0,0,150,100);
        //调用产生字符的方法
        String s = randomCode();

        //获取一个session对象
        HttpSession session = req.getSession();
        //设置session的值为 s 取一个名为sCode
        session.setAttribute("sCode",s);
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60);
        resp.addCookie(cookie);

        //设置字体为楷体、字体倾斜、字号为30
        g.setFont(new Font("楷体",Font.ITALIC,30));
        //给一个随机字体颜色
        g.setColor(new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256)));
        //把产生的字符写上去，从坐标（20,30）开始
        g.drawString(s,20,30);
        //设置一个干扰线的颜色
        g.setColor(new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256)));
        //通过写入的一些直线,并且不同的颜色来做成干扰线（两点之间确定一条直线）因为要多条，所以用for循环
        for (int i = 0; i <10 ; i++) {
            g.drawLine(ran.nextInt(150),ran.nextInt(100),ran.nextInt(150),ran.nextInt(100));
        }
        //通过ImagIO写到页面上
        ImageIO.write(img,"jpg",resp.getOutputStream());

    }
    //写一个方法来产生4个字符
    public String randomCode(){
        StringBuffer str = new StringBuffer();
        Random rand = new Random();
        for (int i = 0; i <=3 ; i++) {
            int r = rand.nextInt(3);
            switch (r){
                case 0:
                    int c0 = rand.nextInt(10);
                    str.append(c0);
                    break;
                case 1:
                    //产生一个65到91个一个数，在转换为字符
                    char ch=(char)(rand.nextInt(26)+65);
                    str.append(ch);
                    break;
                case 2:
                    //产生一个97到133之间的数，转换为字符
                    char ch1=(char)(rand.nextInt(26)+97);
                    str.append(ch1);
                    break;
            }
        }
        return new String(str);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
