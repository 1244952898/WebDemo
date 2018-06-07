package fileupload;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;

/**
 * Created by zy on 2018-6-4.
 */
public class uploadAction extends ActionSupport {
    private File file1;
    // 文件名
    private String file1FileName;
    // 文件的类型(MIME)
    private String file1ContentType;
    public void setFile1(File file1) {
        this.file1 = file1;
    }
    public void setFile1FileName(String file1FileName) {
        this.file1FileName = file1FileName;
    }
    public void setFile1ContentType(String file1ContentType) {
        this.file1ContentType = file1ContentType;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(file1FileName);
        // 获取上传的目录路径
        String path = ServletActionContext.getServletContext().getRealPath("/upload");
        // 创建目标文件对象
        File destFile = new File(path,"zy-"+file1FileName);
        // 把上传的文件，拷贝到目标文件中
        FileUtils.copyFile(file1, destFile);

        return SUCCESS;
    }
}
