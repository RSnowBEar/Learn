package com.RSnowBEar.dao.impl;

import com.RSnowBEar.dao.userDao;
import com.RSnowBEar.entity.User;
import com.RSnowBEar.util.jdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 用户管理模块控制
 */
public class userDaoImpl implements userDao {
    JdbcTemplate temp = jdbcUtil.getJdbcTemplate();

    //查询所有用户
    @Override
    public List<User> selectUserAll() {
        List<User> query = temp.query("select * from user",
                new BeanPropertyRowMapper<>(User.class));
        return query;
    }

    //修改用户昵称
    @Override
    public int updateUserNikenameByID(User user) {
        int update = temp.update("update user set nickName=? where userID=?",
                user.getNickName(), user.getUserId());
        return update;
    }

    //删除用户
    @Override
    public int deleteUserByID(User user) {
        int update = temp.update("delete from user where userID=?",
                user.getUserId());
        return update;
    }

    //查询所有数据的总条数
    @Override
    public Integer countAll() {
        Integer integer = temp.queryForObject("select count(userID) from user",
                Integer.class);
        return integer;
    }

    //分页查询
    @Override
    public List<User> queryLimit(Integer currentPage, Integer rows) {
        List<User> query = temp.query("select * from user limit ?,?",
                new BeanPropertyRowMapper<>(User.class),
                (currentPage - 1) * 10, rows);
        return query;
    }

    //通过userID查找用户信息
    @Override
    public List<User> selectUserByID(User user) {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from user where 1=1");
        if(user.getUserId()!=0){
            sb.append(" and userID="+user.getUserId());
        }
        if(user.getPhone()!=null){
            sb.append(" and phone="+user.getPhone());
        }
        List<User> query = temp.query(sb.toString(),
                new BeanPropertyRowMapper<>(User.class));
        if(sb.toString().equals("select * from user where 1=1"))
            query.clear();
        return query;
    }

    //修改用户
    @Override
    public int updateUserInfoById(User user) {
        StringBuffer sql = new StringBuffer("update user set gander=?,birthday=?,nickName=?,balance=?,integral=?,memberLevel=?");
        if(user.getIconRelativePath()!=null){
            sql.append(",iconRelativePath='"+user.getIconRelativePath()+"'");
        }
        if(user.getIconRealPath()!=null){
            sql.append(",iconRealPath='"+user.getIconRealPath()+"'");
        }
        sql.append(" where userID=?");
        int update = temp.update(sql.toString(),
                user.getGander(),
                user.getBirthday(),
                user.getNickName(),
                user.getBalance(),
                user.getIntegral(),
                user.getMemberLevel(),
                user.getUserId());
        return update;
    }
}
