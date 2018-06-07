package framework;

import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zy on 2018-5-29.
 */
public class RegisterAction {
    public Object Register(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Object uri;
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        User user = new User();
        user.setName(name);
        user.setPwd(pwd);

        UserService userService = new UserService();
        userService.register(user);
      //  uri = request.getRequestDispatcher("/login.jsp");
        uri="registerSuccess";
        return uri;
    }
}
