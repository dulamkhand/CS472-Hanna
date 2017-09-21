package main;

import db.Message;
import db.MessageDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessContactDataServlet
 */
@WebServlet(description = "MessageListServlet", urlPatterns = {"/listMessages"})
public class MessageListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MessageListServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // update counter
        HttpSession session = request.getSession(true);
        if(session.isNew()) session.setAttribute("hitCount", 0);
        int hitCount = (Integer) session.getAttribute("hitCount");
        session.setAttribute("hitCount", ++hitCount);
        
        // read from db
        List<Message> list = new ArrayList<>();
        try {
            list = MessageDAO.list();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MessageListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("messageList", list);
        response.sendRedirect("contactMessages.jsp");
    }
   
}
