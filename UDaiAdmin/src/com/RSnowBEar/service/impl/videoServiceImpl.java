package com.RSnowBEar.service.impl;

import com.RSnowBEar.dao.impl.videoDaoImpl;
import com.RSnowBEar.dao.videoDao;
import com.RSnowBEar.entity.Videos;
import com.RSnowBEar.entity.pageBean;
import com.RSnowBEar.service.videoService;

import java.util.List;

public class videoServiceImpl implements videoService {
    videoDao vd = new videoDaoImpl();

    //分页查询
    @Override
    public pageBean<Videos> queryLimit(String currentPage, String rows) {
        Integer totalSize = vd.countAll();
        pageBean<Videos> pageBean = new pageBean<>();
        pageBean.setTotalSize(totalSize);
        List<Videos> videos = null;
        try{
            videos = vd.queryLimit(Integer.parseInt(currentPage), Integer.parseInt(rows));
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
        }catch (Exception e){
            videos = vd.queryLimit(1,10);
            pageBean.setCurrentPage(1);
        }
        pageBean.setList(videos);
        return pageBean;
    }

    //添加视频
    @Override
    public boolean addVideo(Videos video) {
        int i = vd.insertVideo(video);
        if(i>0)
            return true;
        return false;
    }

    //按照ID查询Video
    @Override
    public List<Videos> queryVideoByID(Videos video) {
        List<Videos> videos = vd.selectVideoByID(video);
        return videos;
    }

    //删除视频
    @Override
    public boolean deleteVideo(Videos video) {
        int i = vd.deleteVideo(video);
        if(i>0)
            return true;
        return false;
    }
}
