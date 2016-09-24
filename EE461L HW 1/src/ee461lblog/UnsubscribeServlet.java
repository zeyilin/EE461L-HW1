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
public class UnsubscribeServlet extends HttpServlet {	
	// Add a subscriber
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        
	    try {
	        if (req.getParameter("unsub_email") != null) {
	            String unsub_email = req.getParameter("unsub_email");
	        	ofy().delete().type(Subscriber.class).id(unsub_email);
	        } else {
	        	resp.sendError(400, "You didn't specify an email!");
	        	return;
	        }  
		    resp.sendRedirect("/index.jsp");
		} catch (Exception e) {
				resp.sendError(400, "Something went wrong. Try again!");
				return;
		}
	}
}
