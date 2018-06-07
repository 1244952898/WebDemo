package Email;

import org.junit.Test;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by zy on 2018-5-9.
 */
public class App_SendMail {
    @Test
    public void testsend() throws Exception {
        Properties prop = new Properties();
        prop.put("mail.transport.protocol", "smtp");    // 指定协议
        prop.put("mail.smtp.host", "localhost");        // 主机   stmp.qq.com
        prop.put("mail.smtp.port", 25);                    // 端口
        prop.put("mail.smtp.auth", "true");                // 用户密码认证
        prop.put("mail.debug", "true");

        Session session = Session.getDefaultInstance(prop);
        MimeMessage message = new MimeMessage(session);
        message.setSubject("我的第一行邮寄");
        message.setSentDate(new Date());
        message.setSender(new InternetAddress("zhangsan@itcast.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("lisi@itcast.com"));
        message.setContent("<a href='http://www.baidu.com'>百度</a>","text/html;charset=utf-8");
//        message.setText("正文正文正文正文正文正文正文正文正文正文正文正文正文");
        message.saveChanges();
        Transport transport = session.getTransport();
        transport.connect("zhangsan","123");
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();

    }
}
