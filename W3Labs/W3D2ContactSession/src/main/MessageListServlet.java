package main;

import java.io.IOException;
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

        response.sendRedirect("contactMessages.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // update counter
        HttpSession session = request.getSession(true);
        if(session.isNew()) session.setAttribute("hitCount", 0);
        int hitCount = (Integer) session.getAttribute("hitCount");
        session.setAttribute("hitCount", ++hitCount);

        response.sendRedirect("contactMessages.jsp");
    }
}
