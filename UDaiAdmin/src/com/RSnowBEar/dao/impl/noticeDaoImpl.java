package com.RSnowBEar.dao.impl;

import com.RSnowBEar.dao.noticeDao;
import com.RSnowBEar.entity.Noticewarehouse;
import com.RSnowBEar.util.jdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class noticeDaoImpl implements noticeDao {
    JdbcTemplate temp = jdbcUtil.getJdbcTemplate();

    //查询数据的总条目数
    @Override
    public Integer countAll() {
        Integer integer = temp.queryForObject("select count(noticeID) from noticewarehouse",
                Integer.class);
        return integer;
    }

    //分页查询
    @Override
    public List<Noticewarehouse> queryLimit(Integer currentPage, Integer rows) {
        List<Noticewarehouse> query = temp.query("select * from noticewarehouse limit ?,?",
                new BeanPropertyRowMapper<>(Noticewarehouse.class),
                (currentPage - 1) * 10, rows);
        return query;
    }

    //添加公告
    @Override
    public int insertNotice(Noticewarehouse notice) {
        int update = temp.update("insert into noticewarehouse values(default,?,?,?)",
                notice.getType(), notice.getTitle(), notice.getContent());
        return update;
    }

    //删除公告
    @Override
    public int deleteNotice(Noticewarehouse notice) {
        int update = temp.update("delete from noticewarehouse where noticeID=?",
                notice.getNoticeId());
        return update;
    }
}
