package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.admin;
import service.adminService;

import java.util.List;

/**
 * Created by zy on 2018-6-6.
 */
public class adminAction extends ActionSupport {

    private admin admin;
    private adminService adminService = new adminService();

    public entity.admin getAdmin() {
        return admin;
    }

    public void setAdmin(entity.admin admin) {
        this.admin = admin;
    }

    public String login() {
        if (admin==null){
            admin=new admin();
            admin.setPwd("aa");
            admin.setUsername("a");
        }
        admin ad = adminService.login(admin);
        if (ad == null)
            return "input";
        ActionContext.getContext().getSession().put("ad", ad);
        return "loginSuccess";
    }

    public String list() {
        try {
            List<admin> list = adminService.getAll();
            ActionContext.getContext().getContextMap().put("list", list);
            return "list";
        } catch (Exception e) {
            return "error";
        }

    }

}
