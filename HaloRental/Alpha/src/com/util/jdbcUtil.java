package com.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.Properties;

public class jdbcUtil {
    private static DataSource ds;

    static{
        try {
            Properties p = new Properties();
            p.load(jdbcUtil.class.getClassLoader().getResourceAsStream("com/config/jdbc.properties"));
            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }

    public static JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(ds);
    }
}
