package impl;

import Dao.IAdminDao;
import entity.Admin;

/**
 * @program: WebDemo
 * @description:
 * @author: Mr.Wang
 * @create: 2018-04-03 16:57
 **/
public class AdminDao implements IAdminDao{
    @Override
    public void Save(Admin admin) {

    }

    @Override
    public boolean IsExsit(String username) {
        return false;
    }

    @Override
    public Admin FindNameAndPassWord(Admin admin) {
        return null;
    }
}
