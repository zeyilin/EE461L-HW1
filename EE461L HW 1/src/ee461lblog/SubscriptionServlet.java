/**
 * Kassidy Knight and Zeyi Lin
 * EE461L HW 1
 * Last updated 9/22/2016
 */
package ee461lblog;

import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SubscriptionServlet extends HttpServlet {	
	// Add a subscriber
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        
        String email = req.getParameter("email");
        String unsub_email = req.getParameter("unsub_email");
        
        if(email == null || unsub_email == null) {
        	resp.sendError(401, "You did not enter an email address");
        } else if (email != null){
        	ofy().save().entity(new Subscriber(email)).now();
        } else if (unsub_email != null){
        	ofy().delete().entity(new Subscriber(email)).now();
        }
	}
	
	// Retrieve subscriber list
	public List<Subscriber> getSubscription() {
		return ofy().load().type(Subscriber.class).list();
	}
}
