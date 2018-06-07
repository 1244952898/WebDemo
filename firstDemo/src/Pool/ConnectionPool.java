package Pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by zy on 2018-4-9.
 */
public class ConnectionPool {
    private int init_count = 3;
    public int current_count = 0;// 记录当前使用连接数
    private int max_count = 6;
    public LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool() {
        for (int i = 0; i < 3; i++) {
            Connection con = CreateConnection();
            pool.add(con);
        }
    }

    public Connection CreateConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zytest", "root", "root");
            Object proxy = Proxy.newProxyInstance(con.getClass().getClassLoader(), new Class[]{Connection.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Object result = null;
                    String methodName = method.getName();
                    if ("close".equals(methodName)&&pool.size() < init_count) {
                        pool.addLast(con);
                        System.out.println("自动放入连接池了");
                    } else {
                        result = method.invoke(con, args);
                    }
                    return result;
                }
            });

            return (Connection) proxy;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Connection GetConnection() {
        if (pool.size() > 0) {
            return pool.removeFirst();
        }

        if (current_count < max_count) {
            current_count++;
            return CreateConnection();
        }

        throw new RuntimeException("超过最大连接数！");
    }

    //4. 释放连接
    public void realeaseConnection(Connection con) {
        // 4.1 判断： 池的数目如果小于初始化连接，就放入池中
        if (pool.size() < init_count) {
            System.out.println(pool.size());
            pool.addLast(con);
        } else {
            try {
                // 4.2 关闭
                current_count--;
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Test{
    public static void main(String[] args) throws SQLException {
        ConnectionPool pool=new ConnectionPool();
        Connection c1=pool.GetConnection();
        c1.close();
    }
}
