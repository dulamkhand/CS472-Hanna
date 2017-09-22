package edu.mum.cs.cs472.w3d3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.cs.cs472.w3d3.dataaccess.ContactMessagesDBFacade;
import edu.mum.cs.cs472.w3d3.model.ContactMessage;

/**
 * Servlet implementation class ListMessagesServlet
 */
@WebServlet("/listMessages")
public class ListMessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListMessagesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("listContactMessages");
		ContactMessagesDBFacade db = new ContactMessagesDBFacade();
		List<ContactMessage> listContactMessages = db.getContactMessages();
		session.setAttribute("listContactMessages", listContactMessages);
		RequestDispatcher rd = request.getRequestDispatcher("contactMessages.jsp");
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
