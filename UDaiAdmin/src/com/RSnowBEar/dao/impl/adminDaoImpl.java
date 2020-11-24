package com.RSnowBEar.dao.impl;

import com.RSnowBEar.dao.adminDao;
import com.RSnowBEar.entity.Administrator;
import com.RSnowBEar.entity.Noticewarehouse;
import com.RSnowBEar.util.jdbcUtil;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class adminDaoImpl implements adminDao {
    JdbcTemplate temp = jdbcUtil.getJdbcTemplate();

    @Override
    public List<Administrator> selectAdminByNamePwd(Administrator admin) {
        List<Administrator> query = temp.query(
                "select adminID,adminName,adminPassword,pid,iconRelativePath,iconRealPath from Administrator where adminName=? and adminPassword=?",
                new BeanPropertyRowMapper<>(Administrator.class),
                admin.getAdminName(), admin.getAdminPassword());
        return query;
    }

    //查询所有数据的总条数
    @Override
    public Integer countAll() {
        Integer integer = temp.queryForObject("select count(adminID) from administrator where pid!=0",
                Integer.class);
        return integer;
    }

    //分页查询
    @Override
    public List<Administrator> queryLimit(Integer currentPage, Integer rows) {
        List<Administrator> query = temp.query("select * from administrator where pid!=0 limit ?,?",
                new BeanPropertyRowMapper<>(Administrator.class),
                (currentPage - 1) * 10, rows);
        return query;
    }

    //添加管理员
    @Override
    public int insertAdmin(Administrator admin) {
        int update = temp.update("insert into administrator values(default,?,?,?,?,?)",
                admin.getAdminName(), admin.getAdminPassword(), admin.getPid(),
                admin.getIconRelativePath(), admin.getIconRealPath());
        return update;
    }

    //删除管理员
    @Override
    public int deleteAdmin(Administrator admin) {
        int update = temp.update("delete from administrator where adminID=?",
                admin.getAdminId());
        return update;
    }
}
