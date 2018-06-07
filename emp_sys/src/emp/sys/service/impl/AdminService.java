package emp.sys.service.impl;

import emp.sys.dao.IAdminDao;
import emp.sys.dao.impl.AdminDao;
import emp.sys.entity.Admin;
import emp.sys.service.IAdminService;

/**
 * Created by zy on 2018-4-13.
 */
public class AdminService implements IAdminService {
    IAdminDao iAdminDao=new AdminDao();
    @Override
    public Admin FindByUserNameAndPwd(Admin admin) {
        return iAdminDao.FindByUserNameAndPwd(admin);
    }
}
