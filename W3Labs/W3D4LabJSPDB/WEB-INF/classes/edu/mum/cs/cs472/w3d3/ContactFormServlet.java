package edu.mum.cs.cs472.w3d3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ContactFormServlet
 */
@WebServlet(description = "ContactFormServlet", urlPatterns = { "/contactForm" })
public class ContactFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int contactFormHitCount;
	private int totalHitCount;
       
    public ContactFormServlet() {
        super();
    }
    
	@Override
	public void init() throws ServletException {
		super.init();
	}    

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.removeAttribute("contactMessage");
		session.removeAttribute("errMsgs");
		session.setAttribute("contactFormHitCount", ++contactFormHitCount);
		session.setAttribute("totalHitCount", totalHitCount + contactFormHitCount);
		RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
