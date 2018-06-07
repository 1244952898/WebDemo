import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by zy on 2018-5-31.
 */
public class HelloAction extends ActionSupport{
private person p;

    public person getP() {
        return p;
    }

    public void setP(person p) {
        this.p = p;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("访问到了Action");
        System.out.println("正在调用Service");
        System.out.println(p.toString());
        return "success";
    }
}
