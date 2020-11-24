package com.RSnowBEar.service.impl;

import com.RSnowBEar.dao.adminDao;
import com.RSnowBEar.dao.impl.adminDaoImpl;
import com.RSnowBEar.entity.Administrator;
import com.RSnowBEar.entity.pageBean;
import com.RSnowBEar.service.adminService;

import java.util.List;

public class adminServiceImpl implements adminService {
    adminDao ad = new adminDaoImpl();

    //登录
    @Override
    public boolean adminLogin(Administrator admin) {
        List<Administrator> administrators = ad.selectAdminByNamePwd(admin);
        if(administrators.size()>0)
            return true;
        return false;
    }

    //分页查询
    @Override
    public pageBean<Administrator> queryLimit(String currentPage, String rows) {
        Integer totalSize = ad.countAll();
        pageBean<Administrator> pageBean = new pageBean<>();
        pageBean.setTotalSize(totalSize);
        List<Administrator> admin = null;
        try{
            admin = ad.queryLimit(Integer.parseInt(currentPage), Integer.parseInt(rows));
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
        }catch (Exception e){
            admin = ad.queryLimit(1,10);
            pageBean.setCurrentPage(1);
        }
        pageBean.setList(admin);
        return pageBean;
    }

    //添加管理员
    @Override
    public boolean addAdmin(Administrator admin) {
        int i = ad.insertAdmin(admin);
        if(i>0)
            return true;
        return false;
    }

    //删除管理员
    @Override
    public boolean delAdmin(Administrator admin) {
        int i = ad.deleteAdmin(admin);
        if(i>0)
            return true;
        return false;
    }
}
