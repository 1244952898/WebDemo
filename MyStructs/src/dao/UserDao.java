package dao;

import entity.User;

/**
 * Created by zy on 2018-5-29.
 */
public class UserDao {
    public User login(User user) {
        if ("a".equalsIgnoreCase(user.getName()) && "b".equalsIgnoreCase(user.getPwd()))
            return user;
        return null;
    }

    public void register(User user){
        System.out.println("注册成功");
    }
}
