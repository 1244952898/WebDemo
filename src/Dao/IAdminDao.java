package Dao;

import entity.Admin;

/**
 * Created by zy on 2018-4-3.
 */
public interface IAdminDao {
 /**
 * @Description:  保存
 * @Param:
 * @return:
 * @Author: Mr.Wang
 * @Date: 2018-4-3
 */
    void Save(Admin admin);
/** 
* @Description: 用户名是否存在 
* @Param:
* @return:  
* @Author: Mr.Wang 
* @Date: 2018-4-3 
*/ 
    boolean IsExsit(String username);

    /** 
    * @Description: 查询用户 
    * @Param:  
    * @return:  
    * @Author: Mr.Wang 
    * @Date: 2018-4-3 
    */ 
    Admin FindNameAndPassWord(Admin admin);
}
