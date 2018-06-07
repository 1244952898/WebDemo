package service;

import dao.UserDao;
import entity.User;

/**
 * Created by zy on 2018-5-29.
 */
public class UserService {
    UserDao userDao=new UserDao();
    public User login(User user) {
        return userDao.login(user);
    }

    public void register(User user){
        userDao.register(user);
    }
}
