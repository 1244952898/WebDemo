package Email;

import org.junit.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Date;
import java.util.Properties;

/**
 * Created by zy on 2018-5-10.
 */
public class App_SendMailWithImg {

    public static Properties properties;
    private static InternetAddress sendMan;

    static {
        properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");    // 指定协议
        properties.put("mail.smtp.host", "localhost");        // 主机   stmp.qq.com
        properties.put("mail.smtp.port", 25);                    // 端口
        properties.put("mail.smtp.auth", "true");                // 用户密码认证
        properties.put("mail.debug", "true");

        try {
            sendMan = new InternetAddress("zhangsan@itcast.com");
        } catch (AddressException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSend() throws MessagingException {
        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        // 3. 设置参数：标题、发件人、收件人、发送时间、内容
        message.setSubject("主标题");
        message.setSender(sendMan);
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("lisi@itcast.com"));
        message.setSentDate(new Date());

        MimeMultipart mixed=new MimeMultipart("mixed");
        message.setContent(mixed);

        MimeBodyPart left=new MimeBodyPart();
        MimeBodyPart right=new MimeBodyPart();
        MimeBodyPart right1=new MimeBodyPart();

        mixed.addBodyPart(left);
        mixed.addBodyPart(right);
        mixed.addBodyPart(right1);

        /******附件********/
        String attr_path = this.getClass().getResource("a.png").getPath();
        DataSource attr_ds = new FileDataSource(new File(attr_path));
        DataHandler attr_handler = new DataHandler(attr_ds);
        right.setDataHandler(attr_handler);
        right.setFileName("a.png");

        String attr_path1 = this.getClass().getResource("b.docx").getPath();
        DataSource attr_ds1 = new FileDataSource(new File(attr_path1));
        DataHandler attr_handler1 = new DataHandler(attr_ds1);
        right1.setDataHandler(attr_handler1);
        right1.setFileName("b.docx");

        MimeMultipart related = new MimeMultipart("related");
        MimeBodyPart content = new MimeBodyPart();
        MimeBodyPart resource = new MimeBodyPart();

        String fileUrl = App_SendMailWithImg.class.getResource("1.jpg").getPath();
        DataSource dataSource = new FileDataSource(new File(fileUrl));
        DataHandler dataHandler = new DataHandler(dataSource);
        resource.setDataHandler(dataHandler);
        resource.setContentID("1.jpg");

        content.setContent("<img src='cid:1.jpg'>","text/html;charset=utf-8");

        related.addBodyPart(content);
        related.addBodyPart(resource);

        left.setContent(related);
       // message.setContent(related);
        Transport trans = session.getTransport();
        trans.connect("zhangsan", "123");
        trans.sendMessage(message, message.getAllRecipients());
        trans.close();

    }
}
