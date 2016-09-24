package ee461lblog;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;

public class CronServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
  		ObjectifyService.register(Subscriber.class);
  		ObjectifyService.register(Post.class);
        StringBuilder msgBody = new StringBuilder("<h3>Testing, testing 123</h3><br><br>");
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("newsletter@ee461l-hw1-144105.appspotmail.com", "Santander Email Updates"));
            SubscriptionServlet allEmails = new SubscriptionServlet();
            for (Subscriber subscriber : allEmails.getSubscription()) {
            	msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(subscriber.getEmail(), subscriber.getEmail()));
            }
            msg.setSubject("Santander Daily Digest");
            msg.setContent(msgBody.toString(), "text/html; charset=utf-8");
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
