package edu.mum.cs.cs472.w3d3;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.cs.cs472.w3d3.dataaccess.ContactMessagesDBFacade;
import edu.mum.cs.cs472.w3d3.model.ContactMessage;

/**
 * Servlet implementation class ProcessContactDataServlet
 */
@WebServlet(description = "ProcessContactDataServlet", urlPatterns = { "/processContact" })
public class ProcessContactDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int contactFormHitCount;
	private int thankYouPageHitCount;
	private int totalHitCount;
       
    public ProcessContactDataServlet() {
        super();
    }

	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contactFormHitCount++;
		totalHitCount = contactFormHitCount + thankYouPageHitCount;
		request.getSession().setAttribute("totalHitCount", totalHitCount);
		response.sendRedirect("contact.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String missingFieldsMsg = "";
		String customerName = request.getParameter("customerName");
		String gender = request.getParameter("radioGender");
		String category = request.getParameter("ddlCategory");
		String message = request.getParameter("message");
		System.out.println("name= "+ customerName + ", gender= " + gender + ", cat= " + category + ", msg= " + message);
		// Check for missing fields data
		if(customerName.equals("")) {
			missingFieldsMsg += "<div class='alert alert-danger' style='color:red;font-size:1em'>Name is missing.</div>";
		}
		if(gender == null) {
			missingFieldsMsg += "<div class='alert alert-danger' style='color:red;'>Gender is missing.</div>";
		}
		if(category.equals("null")) {
			missingFieldsMsg += "<div class='alert alert-danger' style='color:red;'>Category is missing.</div>";
		}
		if(message.equals("")) {
			missingFieldsMsg += "<div class='alert alert-danger' style='color:red;'>Message is missing.</div>";
		}
		
		String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy"));
		ContactMessage contactMessage = new ContactMessage(0, customerName, gender, category, message, currentDate);
		request.getSession().setAttribute("contactMessage", contactMessage);
		
		if(!missingFieldsMsg.equals("")) {
			missingFieldsMsg = "<div><p>" + missingFieldsMsg + "</p></div>";
			HttpSession session = request.getSession();
			session.setAttribute("errMsgs", missingFieldsMsg);
			int contactFormHitCount = (int)session.getAttribute("contactFormHitCount");
			session.setAttribute("contactFormHitCount", ++contactFormHitCount);
			int totalHitCount = (int)session.getAttribute("totalHitCount");
			session.setAttribute("totalHitCount", ++totalHitCount);			
			// redirect back to sender
			response.sendRedirect("contact.jsp");
		} else {
			// Save data to db
			ContactMessagesDBFacade db = new ContactMessagesDBFacade();
			db.saveContactMessage(contactMessage);
			HttpSession session = request.getSession();
			session.removeAttribute("errMsgs");
			session.setAttribute("thankYouPageHitCount", ++thankYouPageHitCount);
			int totalHitCount = (int)session.getAttribute("totalHitCount");
			session.setAttribute("totalHitCount", ++totalHitCount);				
			String redirectUrl = "thankyou.jsp";
			response.sendRedirect(redirectUrl);
		}
	}
}
