package framework;

import com.sun.deploy.net.HttpRequest;
import entity.ActionMapping;
import entity.ActionMappingManager;
import entity.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by zy on 2018-5-29.
 * 拦截所有*.action
 */
public class ActionServlet extends HttpServlet {
    ActionMappingManager actionMappingManager;

    @Override
    public void init() throws ServletException {

        System.out.println("111111111111111111--INIT();");

        actionMappingManager = new ActionMappingManager();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println(req.getClass());
            System.out.println(resp.getClass());

            String uri = req.getRequestURI();
            String actionName = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf(".action"));
            ActionMapping actionMapping = actionMappingManager.getActionMapping(actionName);
            String className = actionMapping.getClassName();
            String methodName = actionMapping.getMethod();

            Class clazz = Class.forName(className);
            Object obj = clazz.newInstance();
            Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            Object returnFlag = method.invoke(obj, req, resp);
            Map<String, Result> map = actionMapping.getResults();
            Result result = map.get(returnFlag);
            String page = result.getPage();
            if ("redirect".equals(result.getType())) {
                resp.sendRedirect(req.getContextPath() + page);
            } else {
                req.getRequestDispatcher(page).forward(req, resp);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
