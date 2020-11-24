package com.RSnowBEar.service;

import com.RSnowBEar.entity.Videos;
import com.RSnowBEar.entity.pageBean;

import java.util.List;

public interface videoService {
    //分页查询
    public pageBean<Videos> queryLimit(String currentPage, String rows);

    //添加视频
    public boolean addVideo(Videos video);

    //按照ID查询video
    public List<Videos> queryVideoByID(Videos videos);

    //删除视频
    public boolean deleteVideo(Videos video);
}
