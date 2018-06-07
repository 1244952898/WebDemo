package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zy on 2018-4-10.
 */
public class Demo {
    public void Test() throws Exception {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/zytest");
//        dataSource.setDriverClass("com.mysql.jdbc.Driver");
//        dataSource.setUser("root");
//        dataSource.setPassword("root");
//        dataSource.setInitialPoolSize(3);
//        dataSource.setMaxPoolSize(6);
//        dataSource.setMaxIdleTime(1000);

        Connection con=dataSource.getConnection();
        con.prepareStatement("UPDATE person SET age=1211113 WHERE id=2").executeUpdate();
        // 关闭
        con.close();
    }

}
class test{
    public static void main(String[] args) throws Exception {
        Demo d=new Demo();
        d.Test();
    }
}