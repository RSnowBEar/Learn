package com.RSnowBEar.dao;

import com.RSnowBEar.entity.Administrator;
import com.RSnowBEar.entity.Noticewarehouse;

import java.util.List;

/**
 * 对管理员表控制模块接口
 */
public interface adminDao {

    //通过用户名和密码查询是否存在该管理员
    public List<Administrator> selectAdminByNamePwd(Administrator admin);

    //查询所有数据的总条数
    public Integer countAll();

    //分页查询
    public List<Administrator> queryLimit(Integer currentPage, Integer rows);

    //添加管理员
    public int insertAdmin(Administrator admin);

    //删除管理员
    public int deleteAdmin(Administrator admin);
}
