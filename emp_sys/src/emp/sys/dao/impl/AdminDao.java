package emp.sys.dao.impl;

import emp.sys.dao.IAdminDao;
import emp.sys.entity.Admin;
import emp.sys.utils.jdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by zy on 2018-4-13.
 */
public class AdminDao implements IAdminDao {
    @Override
    public Admin FindByUserNameAndPwd(Admin admin) {
        try {
            return jdbcUtils.GetDataSource().query("select * from admin where userName=? and pwd=?",new BeanHandler<Admin>(Admin.class),admin.getUserName(),admin.getPwd());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
