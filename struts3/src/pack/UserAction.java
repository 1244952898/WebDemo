package pack;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by zy on 2018-6-1.
 */
public class UserAction extends ActionSupport{
    public String lg(){
        System.out.println("lg");
        return "lg";
    }
    public String rg(){
        System.out.println("rg");
        return "rg";
    }
}
