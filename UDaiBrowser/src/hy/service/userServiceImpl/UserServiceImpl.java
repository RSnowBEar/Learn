package hy.service.userServiceImpl;

import hy.dao.userImpl.UserDaoImpl;
import hy.domain.User;
import hy.service.UserService;


public class UserServiceImpl implements UserService {
    private UserDaoImpl dao;

    public UserServiceImpl() {
        dao = new UserDaoImpl();
    }


    @Override
    public boolean registerUS(User user) {
        int register = dao.register(user);
        if(register>0){
            return true;
        }
        return false;
    }
}


