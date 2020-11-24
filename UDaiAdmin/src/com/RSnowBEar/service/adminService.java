package com.RSnowBEar.service;

import com.RSnowBEar.entity.Administrator;
import com.RSnowBEar.entity.pageBean;
import javafx.scene.AmbientLight;

import java.util.List;

/**
 * 对管理员表控制模块
 */
public interface adminService {

    //登录
    public boolean adminLogin(Administrator admin);

    //分页查询
    public pageBean<Administrator> queryLimit(String currentPage, String rows);

    //添加管理员
    public boolean addAdmin(Administrator admin);

    //删除管理员
    public boolean delAdmin(Administrator admin);
}
