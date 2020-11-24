package com.service.serviceImpl;

import com.CustomException.LoginException;
import com.CustomException.UserRegisterException;
import com.CustomException.UserRentException;
import com.CustomException.UserReturnException;
import com.dao.daoImpl.userDaoImpl;
import com.entity.*;
import com.service.userService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * 用户操作业务层实现类
 */
public class userServiceImpl implements userService {
    private userDaoImpl udi = new userDaoImpl();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //登录
    @Override
    public boolean login(String username, String password){
        List login = udi.login(username, password);
        if(login.size()!=0)
            return true;
        throw new LoginException("[普通用户]用户名或密码输入有误");
    }

    //注册
    @Override
    public boolean register(String userName,String Pwd,String VifPwd,String Sex,String IDNumber,String Tel,String Address) {
        if(!selectUserByUserName(userName)){
            if (Pwd.equals(VifPwd)) {
                if(Sex.equals("男") || Sex.equals("女")) {
                    user u = new user(userName, Pwd, Sex, IDNumber, Tel, Address, 0);
                    int register = udi.register(u);
                    if (register > 0)
                        return true;
                    throw new UserRegisterException("发生未知错误");
                }
                throw new UserRegisterException("性别输入有误");
            }
            throw new UserRegisterException("两次密码不一致");
        }
        throw new UserRegisterException("用户名已存在");
    }

    //查询汽车信息
    /*
        selectNum为查询编号
        1.查询全部
        2.查询已上架车辆（废弃）
        3.按照日租价格升序
        4.同上降序
        5.按照市场价格升序
        6.同上降序
        7.按照车型
        8.按照品牌
        9.按照颜色
     */
    @Override
    public List<selectCarAll> queryCarAll(Integer selectNum,String loginingUName) {
        List query=null;
        if(loginingUName!=null) {
            List<user> list = udi.selectUserByUserName(loginingUName);
            query = udi.selectCarAll(selectNum,list.get(0).getType());
        }
        return query;
    }

    //租赁汽车
    @Override
    public boolean rentCar(String userName,Integer cid,Integer day) {
        //如果查有此车可租
        if(selectCarStatusByCarID(cid)){
            //如果用户名不为空
            if (userName != null) {
                List<user> list = udi.selectUserByUserName(userName);
                if (list.size() != 0) {
                    //天数处理
                    Date start_date = new Date();
                    Calendar c = Calendar.getInstance();
                    c.add(Calendar.DATE, day);
                    Date return_date = c.getTime();

                    try {
                        int i = udi.rentCar(cid,
                                list.get(0).getId(),
                                sdf.format(start_date),
                                sdf.format(return_date));
                        if (i > 0) {
                            return true;
                        }
                        throw new UserRentException("发生未知错误");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            throw new UserRentException("租车用户信息有误");
        }
        throw new UserRentException("该车无法出租");
    }

    //通过车辆编号检查车辆是否可以被租出（true：存在  false：不存在）
    @Override
    public boolean selectCarStatusByCarID(Integer cid) {
        List<car> cars = udi.selectCarCanOrNotRentByCarID(cid);
        if(cars.size()!=0)
            return true;
        return false;
    }

    //归还汽车
    @Override
    public boolean returnCar(String userName,Integer cid) {
        //查找该车是否未归还
        List<record> list = udi.selectCarCanOrNotReturnByCID(cid);
        if(list.size()!=0) {
            if (userName != null) {
                    List<user> user = udi.selectUserByUserName(userName);
                    try {
                        //开始租车日期
                        Date start_date = list.get(0).getStart_date();
                        //预约还车时间
                        Date reserve_date = list.get(0).getReturn_date();
                        //当前还车日期
                        Date return_date = new Date();
                        //实际租赁天数
                        long realDays = 0;
                        //逾期天数
                        long overdueDays = 0;

                        //如果逾期还车
                        if (reserve_date.before(return_date)) {
                            realDays = (return_date.getTime() - start_date.getTime())
                                    / 1000 / 60 / 60 / 24;
                            overdueDays = (return_date.getTime() - reserve_date.getTime())
                                    / 1000 / 60 / 60 / 24;
                        }
                        //如果提前还车
                        else if (reserve_date.after(return_date)) {
                            realDays = (return_date.getTime() - start_date.getTime())
                                    / 1000 / 60 / 60 / 24;
                            overdueDays = 0;
                        }
                        //到期还车
                        else {
                            realDays = (reserve_date.getTime() - start_date.getTime())
                                    / 1000 / 60 / 60 / 24;
                            overdueDays = 0;
                        }
                        //获得所租车辆的日租金
                        List<car> car = udi.selectCarByCID(cid);
                        Float rent = car.get(0).getRent();
                        //计算租金
                        realDays = (realDays < 1 ? 1 : realDays);
                        Float payment = (realDays * rent) + (overdueDays * 100);

                        //还车
                        int i = udi.returnCar(user.get(0).getId(),
                                cid,
                                sdf.format(return_date),
                                payment);
                        if (i > 0)
                            return true;
                        throw new UserReturnException("无法归还其他用户所借车辆");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
            throw new UserReturnException("还车用户信息有误");
        }
        throw new UserReturnException("该车已归还");
    }

    @Override
    public List selectRecord(String userName) {
        List<selectRecord> query=null;
        if(userName!=null){
            List<user> user = udi.selectUserByUserName(userName);
            if(user.size()!=0){
                query = udi.selectRecord(user.get(0).getId());
            }
        }
        return query;
    }

    //通过用户名检查是否已存在该用户（true：已存在  false：不存在）
    @Override
    public boolean selectUserByUserName(String username){
        List userByUserName = udi.selectUserByUserName(username);
        if(userByUserName.size()!=0)
            return true;
        return false;
    }
}
