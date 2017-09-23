package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "ProcessContactDataServlet", urlPatterns = { "/processContact" })
public class ProcessContactDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int hitCount;
       
    public ProcessContactDataServlet() {
        super();
    }

	@Override
	public void init() throws ServletException {
		super.init();
		hitCount++;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hitCount++;
		response.sendRedirect("contact");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hitCount++;
		String missingFieldsMsg = "";
		String customerName = request.getParameter("customerName");
		String gender = request.getParameter("radioGender");
		String category = request.getParameter("ddlCategory");
		String message = request.getParameter("message");
		System.out.println("name= "+ customerName + ", gender= " + gender + ", cat= " + category + ", msg= " + message);
		// Check for missing fields data
		if(customerName.equals("")) {
			missingFieldsMsg += "<span style='color:red;font-size:1em'>Name is missing.</span><br/>";
		}
		if(gender == null) {
			missingFieldsMsg += "<span style='color:red;'>Gender is missing.</span><br/>";
		}
		if(category.equals("null")) {
			missingFieldsMsg += "<span style='color:red;'>Category is missing.</span><br/>";
		}
		if(message.equals("")) {
			missingFieldsMsg += "<span style='color:red;'>Message is missing.</span><br/>";
		}
		if(!missingFieldsMsg.equals("")) {
			request.setAttribute("errMsgs", missingFieldsMsg);
			// forward back to sender
			RequestDispatcher rd = request.getRequestDispatcher("/contact");
			rd.forward(request, response);
		} else {
			String redirectUrl = "thankyou?customerName="+customerName+"&radioGender="+gender+"&ddlCategory="+category+"&message="+message;
			response.sendRedirect(redirectUrl);
		}
	}
}
