package framework;

import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zy on 2018-5-29.
 */
public class LoginAction {
    public Object Login(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Object uri;

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        User user = new User();
        user.setName(name);
        user.setPwd(pwd);

        UserService userService = new UserService();
        User userInfo = userService.login(user);
        if (userInfo==null){
          // uri = request.getRequestDispatcher("/login.jsp");
            uri="loginFail";
        }
        else{
            //request.getSession().setAttribute("userinfo",userInfo);
            // uri = "/index.jsp";
            uri="loginSuccess";
        }
        return uri;
    }
}
