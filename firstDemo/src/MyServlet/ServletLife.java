package MyServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by zy on 2018-3-12.
 */
public class ServletLife extends HttpServlet {
    public ServletLife() {
        System.out.println("1.ServletLife初始化方法调用！");
    }

    @Override
    public void destroy() {
        System.out.println("4.销毁servlet对象的时候调用destroy");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("2.创建完servlet对象的时候调用init1！");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("2.创建完servlet对象的时候调用init2！");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("3.每次发出请求时调用service。");
    }
}
