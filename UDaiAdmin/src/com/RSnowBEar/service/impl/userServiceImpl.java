package com.RSnowBEar.service.impl;

import com.RSnowBEar.dao.impl.userDaoImpl;
import com.RSnowBEar.dao.userDao;
import com.RSnowBEar.entity.User;
import com.RSnowBEar.entity.pageBean;
import com.RSnowBEar.service.userService;

import java.util.List;

public class userServiceImpl implements userService {
    userDao ud = new userDaoImpl();

    //查询所有用户
    @Override
    public List<User> queryUserAll() {
        List<User> users = ud.selectUserAll();
        for (User user : users) {
            user.setLoginPassword(" ");
            user.setPayPassword(" ");
        }
        return users;
    }

    @Override
    public pageBean<User> queryLimit(String currentPage, String rows) {
        Integer totalSize = ud.countAll();
        pageBean<User> pageBean = new pageBean<>();
        pageBean.setTotalSize(totalSize);
        List<User> users = null;
        try{
            users = ud.queryLimit(Integer.parseInt(currentPage), Integer.parseInt(rows));
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
        }catch (Exception e){
            users = ud.queryLimit(1,10);
            pageBean.setCurrentPage(1);
        }
        pageBean.setList(users);
        return pageBean;
    }

    @Override
    public List<User> queryUserByID(User user) {
        List<User> users = ud.selectUserByID(user);
        return users;
    }

    @Override
    public boolean modifyUserInfo(User user) {
        if(user.getIconRealPath()!=null) {
            user.setIconRealPath(user.getIconRealPath().replace("/", "\\"));
        }
        int i = ud.updateUserInfoById(user);
        if(i>0)
            return true;
        return false;
    }

    @Override
    public boolean deleteUserByID(User user) {
        int i = ud.deleteUserByID(user);
        if(i>0)
            return true;
        return false;
    }
}
