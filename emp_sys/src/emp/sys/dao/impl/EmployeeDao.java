package emp.sys.dao.impl;

import emp.sys.dao.IEmployeeDao;
import emp.sys.entity.Employee;
import emp.sys.utils.jdbcUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zy on 2018-4-13.
 */
public class EmployeeDao implements IEmployeeDao {
    @Override
    public List<Employee> GetAll() {
        String sql="select * from employee";
        try {
            return jdbcUtils.GetDataSource().query(sql,new BeanListHandler<Employee>(Employee.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
