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

public class SubscriptionServlet extends HttpServlet {
	public List<Subscriber> getSubscription() {
		return ofy().load().type(Subscriber.class).list();
	}
}
