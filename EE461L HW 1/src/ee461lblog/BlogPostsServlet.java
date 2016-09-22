/**
 * Kassidy Knight and Zeyi Lin
 * EE461L HW 1
 * Last updated 9/21/2016
 */

package ee461lblog;

import com.google.appengine.api.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class BlogPostsServlet extends HttpServlet {
    
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        
        if (user == null) {
        	// if user is not logged in, cannot post
        } else if (req.getParameter("title") == null || req.getParameter("title").isEmpty()) {
        	// check for empty title
        	resp.sendError(400, "No Title");
        } else if (req.getParameter("content") == null || req.getParameter("content").isEmpty()) {
        	// checks for empty content
        	resp.sendError(400, "No Content");
        } else {
        	Post post = new Post(user, req.getParameter("title"), user.getEmail(), req.getParameter("content"));
        	ofy().save().entities(post).now();
        	resp.getWriter().println("Post saved!");
        	resp.sendRedirect("/posts?id=" + post.id);
        }
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
	}
}
