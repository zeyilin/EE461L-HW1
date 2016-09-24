package ee461lblog;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class CronServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        StringBuilder msgBody = new StringBuilder("<h3>Email!</h3><br><br>");
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("newsletter@crontest-144202.appspotmail.com", "Email Updates"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("zeyi.lin@gmail.com", "zeyi"));
            //msg.addRecipient(Message.RecipientType.TO, new InternetAddress("kassiknight@gmail.com", "kassidy"));
            msg.setSubject("Santander Daily Digest");
            msg.setContent(msgBody.toString(), "text/html; charset=utf-8");
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
