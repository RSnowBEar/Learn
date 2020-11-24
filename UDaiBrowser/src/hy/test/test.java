package hy.test;

import hy.domain.User;
import hy.service.userServiceImpl.UserServiceImpl;

public class test {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setPhone("1376574");
        user.setPassword("123455");
        userService.registerUS(user);


    }
}
