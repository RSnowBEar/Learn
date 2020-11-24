package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.Videos;
import com.RSnowBEar.service.impl.videoServiceImpl;
import com.RSnowBEar.service.videoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@MultipartConfig
@WebServlet("/addVideoServlet")
public class addVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取上传的信息
        String title = request.getParameter("title");
        Part img = request.getPart("img");
        Part video = request.getPart("video");

        //2.存入图片
        String imgRelativePath = "img/";
        String imgRealPath = request.getServletContext().getRealPath(imgRelativePath);
        String imgFileName = img.getSubmittedFileName();
        String imgSuffix = imgFileName.substring(imgFileName.lastIndexOf("."));
        imgFileName = UUID.randomUUID().toString()+imgSuffix;
        img.write(imgRealPath+imgFileName);

        //3.存入视频
        String videoRelativePath = "video/";
        String videoRealPath = request.getServletContext().getRealPath(videoRelativePath);
        String videoFileName = video.getSubmittedFileName();
        String videoSuffix = videoFileName.substring(videoFileName.lastIndexOf("."));
        videoFileName = UUID.randomUUID().toString()+videoSuffix;
        video.write(videoRealPath+videoFileName);

        //4.存入数据库
        Videos videos = new Videos();
        videos.setTitle(title);
        videos.setImgRelaticePath(imgRelativePath+imgFileName);
        videos.setImgRealPath(imgRealPath+imgFileName);
        videos.setVideoRelativePath(videoRelativePath+videoFileName);
        videos.setVideoRealPath(videoRealPath+videoFileName);
        videoService vs = new videoServiceImpl();
        boolean b = vs.addVideo(videos);

        //5.返回查询页
        request.getRequestDispatcher("/queryVideoServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
