package hy.util;


//import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class JDBCDruidLastUtil {
    private static DataSource ds;
    static {
        Properties p = new Properties();
        ClassLoader loader = JDBCDruidLastUtil.class.getClassLoader();
        InputStream in = loader.getResourceAsStream("config/druid.properties");
        try {
            //将配置文件加载到Properties这个对象了
            p.load(in);
            //4.获取数据库连接池对象
            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static JdbcTemplate getJdbcTemplate(){
        JdbcTemplate temp = new JdbcTemplate(ds);
        return temp;
    }


}
