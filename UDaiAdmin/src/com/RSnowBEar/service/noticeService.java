package com.RSnowBEar.service;

import com.RSnowBEar.entity.Noticewarehouse;
import com.RSnowBEar.entity.pageBean;

public interface noticeService {
    //分页查询
    public pageBean<Noticewarehouse> queryLimit(String currentPage, String rows);

    //添加公告
    public boolean addNotice(Noticewarehouse notice);

    //删除公告
    public boolean deleteNotice(Noticewarehouse notice);
}
