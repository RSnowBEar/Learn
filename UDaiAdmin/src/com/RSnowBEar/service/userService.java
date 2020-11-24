package com.RSnowBEar.service;

import com.RSnowBEar.entity.User;
import com.RSnowBEar.entity.pageBean;

import java.util.List;

/**
 * 用户管理模块控制
 */
public interface userService {

    //查询所有用户
    public List<User> queryUserAll();

    //分页查询
    public pageBean<User> queryLimit(String currentPage, String rows);

    //通过用户ID查询信息
    public List<User> queryUserByID(User user);

    //修改用户信息
    public boolean modifyUserInfo(User user);

    //删除用户
    public boolean deleteUserByID(User user);
}
