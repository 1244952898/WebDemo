package emp.sys.service;

import emp.sys.entity.Employee;

import java.util.List;

/**
 * Created by zy on 2018-4-13.
 */
public interface IEmployeeService {
    public List<Employee> GetAll();
}
