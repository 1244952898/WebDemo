package MyServlet;

import java.io.IOException;
import java.util.Date;

/**
 * Created by zy on 2018-3-6.
 */
public class ServletDemo1 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("zhe是di一个ziyuan：时间：" + new Date());
    }
}
