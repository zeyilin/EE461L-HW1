/**
 * Kassidy Knight and Zeyi Lin
 * EE461L HW 1
 * Last updated 9/21/2016
 */

package ee461lblog;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class EE461L_HW_1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
