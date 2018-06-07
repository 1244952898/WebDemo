package MyServlet.webdemo.zytest;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by zy on 2018-3-20.
 */
public class IPTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        PageContext context = (PageContext)this.getJspContext();
        ServletRequest request = context.getRequest();
        String ip = request.getRemoteHost();
        JspWriter out = context.getOut();
        out.write(ip);
    }
}
