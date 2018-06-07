package utils;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by zy on 2018-4-3.
 */
public class jdbcUtil {
    private static String url = null;
    private static String username = null;
    private static String password = null;
    private static String driverName = null;

    static {
        Properties properties = new Properties();
        InputStream inputStream = jdbcUtil.class.getResourceAsStream("/jdbc/db.properties");
        try {
            properties.load(inputStream);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driverName = properties.getProperty("driver");
            Class.forName(driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeAll(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();  // 快速异常捕获 Alt + shift + z
                rs = null;   // 建议垃圾回收期回收资源
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (con != null && !con.isClosed()) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeAll(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();  // 快速异常捕获 Alt + shift + z
                rs = null;   // 建议垃圾回收期回收资源
            }
            if (pstmt != null) {
                pstmt.close();
                pstmt = null;
            }
            if (con != null && !con.isClosed()) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
