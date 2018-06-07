package servlet;

import entity.User;
import framework.LoginAction;
import service.UserService;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

/**
 * Created by zy on 2018-5-29.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        LoginAction action = new LoginAction();
        Object uri = action.Login(request, response);
        if (uri instanceof String) {
            response.sendRedirect(request.getContextPath() + uri.toString());
        } else {
            ((RequestDispatcher) uri).forward(request, response);
        }

    }
}
