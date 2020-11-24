package com.RSnowBEar.dao;

import com.RSnowBEar.entity.Videos;

import java.util.List;

public interface videoDao {
    //查询所有数据的总条数
    public Integer countAll();

    //分页查询
    public List<Videos> queryLimit(Integer currentPage, Integer rows);

    //添加视频
    public int insertVideo(Videos video);

    //按照ID查询
    public List<Videos> selectVideoByID(Videos video);

    //删除视频
    public int deleteVideo(Videos video);
}
