package com.RSnowBEar.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtil {
    private static DataSource ds;

    static{
        try {
            Properties p = new Properties();
            InputStream resourceAsStream = jdbcUtil.class.getClassLoader().getResourceAsStream("com/RSnowBEar/conf/jdbc.properties");
            p.load(resourceAsStream);
            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(ds);
    }
}
