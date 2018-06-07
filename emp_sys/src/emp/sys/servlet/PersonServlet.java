package emp.sys.servlet;

import emp.sys.entity.person;
import emp.sys.service.IPersonService;
import emp.sys.service.impl.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zy on 2018-5-25.
 */
public class PersonServlet extends HttpServlet {
    IPersonService service=new PersonService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("111");
        person p = service.Get(1);
        System.out.println(p);
    }
}
