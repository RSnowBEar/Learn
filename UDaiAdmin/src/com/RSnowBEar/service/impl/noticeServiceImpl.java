package com.RSnowBEar.service.impl;

import com.RSnowBEar.dao.impl.noticeDaoImpl;
import com.RSnowBEar.dao.noticeDao;
import com.RSnowBEar.entity.Noticewarehouse;
import com.RSnowBEar.entity.User;
import com.RSnowBEar.entity.pageBean;
import com.RSnowBEar.service.noticeService;

import java.util.List;

public class noticeServiceImpl implements noticeService {
    noticeDao nd = new noticeDaoImpl();

    //分页查询
    @Override
    public pageBean<Noticewarehouse> queryLimit(String currentPage, String rows) {
        Integer totalSize = nd.countAll();
        pageBean<Noticewarehouse> pageBean = new pageBean<>();
        pageBean.setTotalSize(totalSize);
        List<Noticewarehouse> notices = null;
        try{
            notices = nd.queryLimit(Integer.parseInt(currentPage), Integer.parseInt(rows));
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
        }catch (Exception e){
            notices = nd.queryLimit(1,10);
            pageBean.setCurrentPage(1);
        }
        pageBean.setList(notices);
        return pageBean;
    }

    //添加公告
    @Override
    public boolean addNotice(Noticewarehouse notice) {
        int i = nd.insertNotice(notice);
        if(i>0)
            return true;
        return false;
    }

    //删除公告
    @Override
    public boolean deleteNotice(Noticewarehouse notice) {
        int i = nd.deleteNotice(notice);
        if(i>0)
            return true;
        return false;
    }


}
