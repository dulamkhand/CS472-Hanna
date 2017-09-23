package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "ProcessAccountFormData", urlPatterns = {"/processAccountFormData"})
public class ProcessAccountFormData extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ProcessAccountFormData() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("contact");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String missingFieldsMsg = "";
        String accountNo = request.getParameter("accountNo");
        String customerName = request.getParameter("customerName");
        String type = request.getParameter("type");

        if (accountNo == null || "".equals(accountNo) || "01-XXX-XXXX".equals(accountNo)) {
            missingFieldsMsg += "<span style='color:red;'>Account number is missing.</span><br/>";
        }
        if (customerName == null || "".equals(customerName)) {
            missingFieldsMsg += "<span style='color:red;'>Customer Name is missing.</span><br/>";
        }

        if (!missingFieldsMsg.equals("")) {
            request.setAttribute("errMsgs", missingFieldsMsg);
            RequestDispatcher rd = request.getRequestDispatcher("/accountForm");
            rd.forward(request, response);
        } else {
            request.getSession().setAttribute("account", new Account(customerName, accountNo, type));
            response.sendRedirect("thankyou.jsp");
        }
    }
}
