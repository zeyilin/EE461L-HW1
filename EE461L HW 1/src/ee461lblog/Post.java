/**
 * Kassidy Knight and Zeyi Lin
 * EE461L HW 1
 * Last updated 9/21/2016
 */

package ee461lblog;

import java.util.Date;
import com.google.appengine.api.users.User;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Post implements Comparable<Post> {
	@Id Long id;
	User author;
	String title;
	String author_email;
	String content;
	Date date;
	
	private Post() {}
	
	public Post(User author, String title, String author_email, String content) {
		this.author = author;
		this.title = title;
		this.author_email = author_email;
		this.content = content;
		this.date = new Date();
	}
	
	public User getAuthor() {
		return author;
	}
	
	public String getContent() {
		return content;
	}
	
	@Override
	public int compareTo(Post other) {
		if (date.after(other.date)) {
			return 1;
		} else if (date.before(other.date)) {
			return -1;
		} else {
			// posts being compared were made on the same date
			return 0;
		}
	}
}
