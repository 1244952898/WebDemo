package MyServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by zy on 2018-3-8.
 */
public class Servletrequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//String name=
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

/*
private void T1(HttpServletRequest request, HttpServletResponse response) throws IOException {
Enumeration<String> names = request.getHeaderNames();
while (names.hasMoreElements()) {
String name = names.nextElement();
System.out.println(name);
}

InputStream inputStream=request.getInputStream();
byte[] bytes=new byte[1024];
int len=0;
while ((len=inputStream.read(bytes))!=-1){
String s=new String(bytes,0,len);
System.out.println(s);
}
response.setContentType("text/html;charset=utf-8");
response.getWriter().write("ServletRequest时间：" + new Date());
}
*/
}
