package com.RSnowBEar.dao;

import com.RSnowBEar.entity.Noticewarehouse;

import java.util.List;

public interface noticeDao {

    //查询所有数据的总条数
    public Integer countAll();

    //分页查询
    public List<Noticewarehouse> queryLimit(Integer currentPage, Integer rows);

    //添加公告
    public int insertNotice(Noticewarehouse notice);

    //删除公告
    public int deleteNotice(Noticewarehouse notice);
}
