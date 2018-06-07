package service;

import dao.adminDao;
import entity.admin;

import java.util.List;

/**
 * Created by zy on 2018-6-6.
 */
public class adminService {
    private adminDao dao=new adminDao();

    public admin login(admin admin){
        return dao.login(admin);
    }

    public List<admin> getAll(){
       return dao.getAll();
    }
}
