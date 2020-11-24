package com.RSnowBEar.servlet;

import com.RSnowBEar.entity.Videos;
import com.RSnowBEar.service.impl.videoServiceImpl;
import com.RSnowBEar.service.videoService;
import com.RSnowBEar.util.jsonReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteVideoServlet")
public class deleteVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取要删除的ID
        Long videoId = Long.valueOf(request.getParameter("videoId"));

        //2.从数据库获取源路径
        videoService vs = new videoServiceImpl();
        Videos video = vs.queryVideoByID(new Videos(videoId)).get(0);
        String videoRealPath = video.getVideoRealPath();
        String imgRealPath = video.getImgRealPath();

        //3.删除源视频文件
        File v = new File(videoRealPath);
        if(v.exists()) {
            v.delete();
        }

        //4.删除源封面图
        File i = new File(imgRealPath);
        if(i.exists()) {
            i.delete();
        }

        //5.删除数据库记录
        vs.deleteVideo(new Videos(videoId));
    }

    protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
