package entity;

import java.util.Map;

/**
 * Created by zy on 2018-5-29.
 * 封装action节点
 * <action name="login" class="framework.LoginAction" method="login">
 * <result name="loginSuccess" type="redirect">/index.jsp</result>
 * <result name="loginSuccess">/login.jsp</result>
 * </action>
 */

public class ActionMapping {
    private String name;
    private String className;
    private String method;
    private Map<String,Result> results;

    public Map<String, Result> getResults() {
        return results;
    }

    public void setResults(Map<String, Result> results) {
        this.results = results;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
