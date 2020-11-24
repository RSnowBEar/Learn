package hy.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @Deacription 在此编写描述信息
 * @Author Administrator
 * @Date 2020/10/13 11:53
 * @Version 1.0
 **/
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletOutputStream out = response.getOutputStream();
        String filename = request.getParameter("filename");
        if(filename!=null){
            ServletContext context = this.getServletContext();
            String realPath = context.getRealPath("/img/" + filename);
            File f = new File(realPath);
            if(f.exists()){
                String mimeType = context.getMimeType(filename);
                response.setHeader("content-type",mimeType);
                UUID uuid = UUID.randomUUID();
                String s = uuid.toString().replace("-","");
                response.setHeader("content-disposition","attachment;filename="+s+".jpg");
                FileInputStream fis = new FileInputStream(f);
                byte[] buf = new byte[1024];
                int len=0;
                while((len=fis.read(buf))!=-1){
                    out.write(buf,0,len);
                }
                fis.close();
            }else{
                out.write("<h1>404</h1>".getBytes());
            }
        }else{
            out.write("<h1>404</h1>".getBytes());
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
