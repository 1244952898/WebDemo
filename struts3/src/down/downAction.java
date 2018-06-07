package down;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.URL;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by zy on 2018-6-4.
 */
public class downAction extends ActionSupport {

    public String list() {
        String path = ServletActionContext.getServletContext().getRealPath("/upload");
        File file = new File(path);
        String[] fileNames = file.list();
        ActionContext ac = ActionContext.getContext();
        Map<String, Object> request = (Map<String, Object>) ac.get("request");
        request.put("fileNames", fileNames);
        return "list";
    }
    private String filename;
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        try {
            filename=new String(filename.getBytes("ISO8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        this.filename = filename;
    }

    public String down() {
        return "download";
    }

    public InputStream getAttrInputStream(){
        System.out.println(ServletActionContext.getServletContext().getRealPath("/upload"+filename));
        return ServletActionContext.getServletContext().getResourceAsStream("/upload/"+filename);
    }

    public String getDownFileName(){
        try {
            filename= URLEncoder.encode(filename,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return filename;
    }

}
