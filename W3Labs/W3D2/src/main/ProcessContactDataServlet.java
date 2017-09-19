package main;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessContactDataServlet
 */
@WebServlet(description = "ProcessContactDataServlet", urlPatterns = {"/processContact"})
public class ProcessContactDataServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ProcessContactDataServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // update counter
        HttpSession session = request.getSession(true);
        int hitCount = (Integer) session.getAttribute("hitCount");
        session.setAttribute("hitCount", ++hitCount);

        response.sendRedirect("contact");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // update counter
        HttpSession session = request.getSession(true);
        int hitCount = (Integer) session.getAttribute("hitCount");
        session.setAttribute("hitCount", ++hitCount);

        String missingFieldsMsg = "";
        String customerName = request.getParameter("customerName");
        String gender = request.getParameter("radioGender");
        String category = request.getParameter("ddlCategory");
        String message = request.getParameter("message");
        System.out.println("name= " + customerName + ", gender= " + gender + ", cat= " + category + ", msg= " + message);
        // Check for missing fields data
        if (customerName.equals("")) {
            missingFieldsMsg += "<span style='color:red;font-size:1em'>Name is missing.</span><br/>";
        }
        if (gender == null) {
            missingFieldsMsg += "<span style='color:red;'>Gender is missing.</span><br/>";
        }
        if (category.equals("null")) {
            missingFieldsMsg += "<span style='color:red;'>Category is missing.</span><br/>";
        }
        if (message.equals("")) {
            missingFieldsMsg += "<span style='color:red;'>Message is missing.</span><br/>";
        }
        if (!missingFieldsMsg.equals("")) {
            //request.setAttribute("errMsgs", missingFieldsMsg);
            session.setAttribute("errMsgs", missingFieldsMsg);
            // forward back to sender
            RequestDispatcher rd = request.getRequestDispatcher("/contact");
            rd.forward(request, response);
        } else {
            session.setAttribute("customerName", customerName);
            session.setAttribute("radioGender", gender);
            session.setAttribute("ddlCategory", category);
            session.setAttribute("message", message);
            
            response.sendRedirect("thankyou");
        }
    }
}
