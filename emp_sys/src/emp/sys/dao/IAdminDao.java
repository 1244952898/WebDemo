package emp.sys.dao;

import emp.sys.entity.Admin;

/**
 * Created by zy on 2018-4-13.
 */
public interface IAdminDao {
    Admin FindByUserNameAndPwd(Admin admin);

}
