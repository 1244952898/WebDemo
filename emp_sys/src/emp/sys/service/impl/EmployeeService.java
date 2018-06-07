package emp.sys.service.impl;

import emp.sys.dao.IEmployeeDao;
import emp.sys.dao.impl.EmployeeDao;
import emp.sys.entity.Employee;
import emp.sys.service.IEmployeeService;

import java.util.List;

/**
 * Created by zy on 2018-4-13.
 */
public class EmployeeService implements IEmployeeService {
    IEmployeeDao iEmployeeDao=new EmployeeDao();

    @Override
    public List<Employee> GetAll() {
        return iEmployeeDao.GetAll();
    }
}
