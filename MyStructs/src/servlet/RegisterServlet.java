package servlet;

import framework.RegisterAction;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

/**
 * Created by zy on 2018-5-29.
 */
public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RegisterAction registerAction = new RegisterAction();
        Object uri = registerAction.Register(request, response);
        ((RequestDispatcher) uri).forward(request, response);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
