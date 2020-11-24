package hy.dao.userImpl;

import hy.dao.userDao;
import hy.domain.User;
import hy.util.JDBCDruidLastUtil;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements userDao {

    private JdbcTemplate temp = JDBCDruidLastUtil.getJdbcTemplate();


    @Override
    public int register(User user) {
        String sql="insert into user (phone,password) values (?,?)";
        int update = temp.update(sql, user.getPhone(), user.getPassword());
        return update;
    }
}
