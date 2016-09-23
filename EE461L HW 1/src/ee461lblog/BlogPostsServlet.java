/**
 * Kassidy Knight and Zeyi Lin
 * EE461L HW 1
 * Last updated 9/21/2016
 */

package ee461lblog;

import com.google.appengine.api.*;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
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
import java.util.ArrayList;

public class BlogPostsServlet extends HttpServlet {
    
	// Write a post
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
		    UserService userService = UserServiceFactory.getUserService();
		    User user = userService.getCurrentUser();
		    String title = req.getParameter("title");
		    String author_email = user.getEmail();
		    String content = req.getParameter("content");
		    
		    if (user == null) {
		    	// if user is not logged in, cannot post
		    } else if (req.getParameter("title") == null || req.getParameter("title").isEmpty()) {
		    	// check for empty title
		    	resp.sendError(400, "No Title");
		    } else if (req.getParameter("content") == null || req.getParameter("content").isEmpty()) {
		    	// checks for empty content
		    	resp.sendError(400, "No Content");
		    } else {
		    	Post post = new Post(user, title, author_email, content);
		    	ofy().save().entities(post).now();
		    	resp.getWriter().println("Post saved!");
		    	resp.sendRedirect("/posts?id=" + post.id);
		    }
		    resp.sendRedirect("/index.jsp");
		} catch (Exception e) {
			resp.sendError(400, "Something went wrong. Try again!");
		}
	}
	
	// Retrieve entire post list - for show all
	public List<Post> getAllPosts() {
		return ofy().load().type(Post.class).list();
	}
	
	// Retrieve 5 latest posts - to display on homepage
	public List<Post> getFivePosts() {
		int index = this.getAllPosts().size() - 1;
		return this.getAllPosts().subList(index - 5, index);
	}
	
	// Retrieve updated posts in the last 24 hours - to email
	public List<Post> getRecentPosts() {
		Date compareDate = new Date(System.currentTimeMillis() - 24 * 3600 * 1000);
		List<Post> results = new ArrayList<Post>();
		for (Post post : this.getAllPosts()) {
			if (post.getDate().after(compareDate)) {
				results.add(post);
			}
		}
		return results;
	}
}
