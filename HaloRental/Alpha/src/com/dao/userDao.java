package com.dao;

import com.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *用户操作数据访问层
 */
public interface userDao {
    //登录
    public List<user> login(String username,String password);

    //注册
    public int register(user user);

    //查询汽车信息
    public List<car> selectCarAll(Integer selectNum,Integer type);

    //租赁汽车
    public int rentCar(Integer cid, Integer uid, String start_date, String return_date) throws SQLException;

    //通过车辆编号查找汽车是否可被租出
    public List<car> selectCarCanOrNotRentByCarID(Integer cid);

    //归还汽车
    public int returnCar(Integer uid,Integer cid,String return_date,Float payment) throws SQLException;

    //通过车辆编号查找汽车是否未归还
    public List selectCarCanOrNotReturnByCID(Integer cid);

    //通过用户名查找用户
    public List selectUserByUserName(String username);

    //通过汽车编号查找汽车
    public List selectCarByCID(Integer cid);

    //查询租赁记录
    public List selectRecord(Integer uid);

    //从框架中获取Conn对象
    public Connection getconn() throws SQLException;

}
