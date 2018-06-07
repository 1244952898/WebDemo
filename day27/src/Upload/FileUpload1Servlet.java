package Upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by zy on 2018-5-16.
 */
public class FileUpload1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(1);
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(1);
        FileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload fileUpload=new ServletFileUpload(factory);
        if (fileUpload.isMultipartContent(request)){
            try {
                List<FileItem> items = fileUpload.parseRequest(request);
                for (FileItem item :
                        items) {
                    if (item.isFormField()){
                        // 普通文本数据
                        String fieldName = item.getFieldName();	// 表单元素名称
                        String content = item.getString();		// 表单元素名称， 对应的数据
                        //item.getString("UTF-8");  指定编码
                        System.out.println(fieldName + " " + content);
                    }else {
                        String fieldName = item.getFieldName();	// 表单元素名称
                        String name = item.getName();			// 文件名
                        String content = item.getString();		// 表单元素名称， 对应的数据
                        String type = item.getContentType();	// 文件类型
                        InputStream in = item.getInputStream(); // 上传文件流
                        System.out.println(fieldName);
                        System.out.println(name);
                        System.out.println(content);
                        System.out.println(type);
                        /*
						 *  四、文件名重名
						 *  对于不同用户readme.txt文件，不希望覆盖！
						 *  后台处理： 给用户添加一个唯一标记!
						 */
                        // a. 随机生成一个唯一标记
//                        String id = UUID.randomUUID().toString();
//                        // b. 与文件名拼接
//                        name = id +"#"+ name;
//                        // 获取上传基路径
//                        String path = getServletContext().getRealPath("/upload");
//                        // 创建目标文件
//                        File file = new File(path,name);
//
//                        // 工具类，文件上传
//                        item.write(file);
//                        item.delete();   //删除系统产生的临时文件
//
//                        System.out.println();


                    }
                }
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("当前表单不是文件上传表单，处理失败！");
        }
    }
}
