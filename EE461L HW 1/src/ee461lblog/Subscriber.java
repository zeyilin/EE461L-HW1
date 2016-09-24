/**
 * Kassidy Knight and Zeyi Lin
 * EE461L HW 1
 * Last updated 9/21/2016
 */

package ee461lblog;

import com.google.appengine.api.users.User;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Subscriber{
	@Id Long sub_id;
	public String sub_email;
	
	private Subscriber() {}
	
	public Subscriber(String sub_email) {
		this.sub_email = sub_email;
	}
}
