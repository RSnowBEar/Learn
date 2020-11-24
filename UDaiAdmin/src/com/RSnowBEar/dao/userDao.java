package com.RSnowBEar.dao;

import com.RSnowBEar.entity.User;

import java.util.List;

/**
 * 用户管理模块控制接口
 */
public interface userDao {

    //查看所有用户信息
    public List<User> selectUserAll();

    //修改用户昵称
    public int updateUserNikenameByID(User user);

    //删除用户
    public int deleteUserByID(User user);

    //查询所有数据的总条数
    public Integer countAll();

    //分页查询
    public List<User> queryLimit(Integer currentPage, Integer rows);

    //通过userID查找用户信息
    public List<User> selectUserByID(User user);

    //修改用户
    public int updateUserInfoById(User user);
}
