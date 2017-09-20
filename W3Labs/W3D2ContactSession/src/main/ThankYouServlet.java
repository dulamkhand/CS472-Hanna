package main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ThankYouServlet
 */
@WebServlet(description = "ThankYouServlet", urlPatterns = { "/thankyou" })
public class ThankYouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThankYouServlet() {
        super();
    }    

	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// update counter
                HttpSession session = request.getSession(true);
                if(session.isNew()) session.setAttribute("hitCount", 0);
                int hitCount = (Integer) session.getAttribute("hitCount");
                session.setAttribute("hitCount", ++hitCount);

                String customerName = (String) session.getAttribute("customerName");
		String gender = (String) session.getAttribute("radioGender");
		String category = (String) session.getAttribute("ddlCategory");
		String message = (String) session.getAttribute("message");
                
		response.setContentType("text/html");
		response.setBufferSize(8192);
		String output = this.generateThankYouPage(customerName, gender, category, message, hitCount);
		try (PrintWriter pw = response.getWriter()) {
			pw.println(output);
		}			
	}
	
	private String generateThankYouPage(String customerName, String gender, 
                String category, String message, int hitCount) {
		StringBuilder sb = new StringBuilder();
		return sb.toString(); 
	}
}
