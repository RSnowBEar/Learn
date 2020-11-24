package com.service;

import com.entity.user;

import java.util.List;

/**
 * 用户操作业务层
 */
public interface userService {
    //登录
    public boolean login(String username,String password);

    //注册
    public boolean register(String userName,String Pwd,String VifPwd,String Sex,String IDNumber,String Tel,String Address);

    //查询汽车信息
    public List queryCarAll(Integer selectNum,String userName);

    //租赁汽车
    public boolean rentCar(String userName,Integer cid,Integer day);

    //通过车辆编号查找汽车
    public boolean selectCarStatusByCarID(Integer cid);

    //归还汽车
    public boolean returnCar(String userName,Integer cid);

    //通过用户名查找用户
    public boolean selectUserByUserName(String username);

    //查询租赁记录
    public List selectRecord(String userName);
}
