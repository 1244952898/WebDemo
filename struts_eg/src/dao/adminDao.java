package dao;

import entity.admin;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.jdbcUtils;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by zy on 2018-6-6.
 */
public class adminDao {
    public admin login(admin admin){
        String sql="select * from admin where username=? and pwd=?";
        try {
            return jdbcUtils.GetDataSource().query(sql,new BeanHandler<admin>(admin.class),admin.getUsername(),admin.getPwd());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<admin> getAll(){
        String sql="select * from admin";
        try {
            return jdbcUtils.GetDataSource().query(sql,new BeanListHandler<admin>(admin.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
