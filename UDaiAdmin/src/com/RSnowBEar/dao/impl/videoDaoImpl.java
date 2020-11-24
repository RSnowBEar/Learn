package com.RSnowBEar.dao.impl;

import com.RSnowBEar.dao.videoDao;
import com.RSnowBEar.entity.Videos;
import com.RSnowBEar.util.jdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class videoDaoImpl implements videoDao{
    JdbcTemplate temp = jdbcUtil.getJdbcTemplate();

    //查询所有数据的总条数
    @Override
    public Integer countAll() {
        Integer integer = temp.queryForObject("select count(videoID) from videos",
                Integer.class);
        return integer;
    }

    //分页查询
    @Override
    public List<Videos> queryLimit(Integer currentPage, Integer rows) {
        List<Videos> query = temp.query("select * from videos limit ?,?",
                new BeanPropertyRowMapper<>(Videos.class),
                (currentPage - 1) * 10, rows);
        return query;
    }

    //添加视频
    @Override
    public int insertVideo(Videos video) {
        int update = temp.update("insert into videos values(default,?,?,?,?,?)",
                video.getTitle(),
                video.getVideoRelativePath(),
                video.getVideoRealPath(),
                video.getImgRelaticePath(),
                video.getImgRealPath());
        return update;
    }

    //按照ID查询
    @Override
    public List<Videos> selectVideoByID(Videos video) {
        List<Videos> query = temp.query("select * from videos where videoID=?",
                new BeanPropertyRowMapper<>(Videos.class),
                video.getVideoId());
        return query;
    }

    //删除视频
    @Override
    public int deleteVideo(Videos video) {
        int update = temp.update("delete from videos where videoID=?",
                video.getVideoId());
        return update;
    }
}
