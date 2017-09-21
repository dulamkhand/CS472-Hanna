package main;

import db.MessageDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            session.setAttribute("errMsgs", missingFieldsMsg);
            // forward back to sender
            RequestDispatcher rd = request.getRequestDispatcher("/contact");
            rd.forward(request, response);
        } else {
            // store un session
            session.setAttribute("customerName", customerName);
            session.setAttribute("gender", gender);
            session.setAttribute("category", category);
            session.setAttribute("message", message);
            
            // update list in session
            if(session.isNew()) session.setAttribute("data", new ArrayList<ContactMessage>());
            List<ContactMessage> data = (List<ContactMessage>) session.getAttribute("data");
            if(data == null || !(data instanceof ArrayList)) data =  new ArrayList<ContactMessage>();
            data.add(new ContactMessage(customerName, gender, category, message));
            session.setAttribute("data", data);
            for(ContactMessage d : data) {
                System.out.println(String.format("%s, %s, %s, %s", d.getName(), 
                        d.getGender(), d.getCategory(), d.getMessage()));
            }
            
            // store in db
            try {
                MessageDAO.insert(customerName, gender, category, message);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessContactDataServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessContactDataServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("thankyou.jsp");
        }
    }
}
