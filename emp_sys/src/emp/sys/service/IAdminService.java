package emp.sys.service;

import emp.sys.entity.Admin;

/**
 * Created by zy on 2018-4-13.
 */
public interface IAdminService {
    public Admin FindByUserNameAndPwd(Admin admin);
}
