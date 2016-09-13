package ee461lblog;

import java.util.Date;
import com.google.appengine.api.users.User;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Post implements Comparable<Post> {
	@Id Long id;
	User user;
	String content;
	Date date;
	
	private Post() {}
	
	public Post(User user, String content) {
		this.user = user;
		this.content = content;
		date = new Date();
	}
	
	public User getUser() {
		return user;
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
