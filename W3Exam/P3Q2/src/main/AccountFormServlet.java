package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "AccountFormServlet", urlPatterns = {"/accountForm"})
public class AccountFormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private int hitCount;

    public AccountFormServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        hitCount++;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hitCount++;
        response.setContentType("text/html");
        response.setBufferSize(8192);
        String output = this.generateContactForm(request, response);
        try (PrintWriter pw = response.getWriter()) {
            pw.println(output);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private String generateContactForm(HttpServletRequest request, HttpServletResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html lang='en'>");
        sb.append("<head>");
        sb.append("    <meta charset='UTF-8'>");
        sb.append("    <meta name='viewport' content='width=device-width, initial-scale=1.0', shrink-to-fit=no\">");
        sb.append("    <meta http-equiv='X-UA-Compatible' content='ie=edge'>");
        sb.append("    <title>Customer Contact App</title>");
        sb.append("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\" integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\" crossorigin=\"anonymous\">");
        sb.append("    <link rel=\"stylesheet\" href=\"css/main.css\">");
        sb.append("<style type=\"text/css\">");
        sb.append("html {");
        sb.append("	  position: relative;");
        sb.append("	  min-height: 100%;");
        sb.append("	}");
        sb.append("	body {");
        sb.append("margin-bottom: 40px;");
        sb.append("} ");
        sb.append(".footer {");
        sb.append("position: absolute;");
        sb.append("bottom: 0;");
        sb.append("width: 100%;");
        sb.append("height: 40px;");
        sb.append("line-height: 40px; ");
        sb.append("background-color: #f5f5f5;");
        sb.append("}");
        sb.append("</style>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">");
        sb.append("<a class=\"navbar-brand\" href=\"index.html\">CS472 ::: MiniBanking App</a>");
        sb.append("<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarsExampleDefault\" aria-controls=\"navbarsExampleDefault\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
        sb.append("<span class=\"navbar-toggler-icon\"></span>");
        sb.append("</button>");
        sb.append("</nav>");
        sb.append("<div class=\"container\">");
        sb.append("<form id=\"formCustomerContact\" method=\"post\" action=\"#\">");
        sb.append("<fieldset>");
        sb.append("<legend>Bank Account Form</legend>");

        // Check if msg exist
        Object objErrMsgs = request.getAttribute("errMsgs");
        if (objErrMsgs != null) {
            String errorMsgs = (String) objErrMsgs;
            sb.append("<div><p>");
            sb.append(errorMsgs);
            sb.append("</p></div>");
        }

        String accountNo = request.getParameter("accountNo");
        String customerName = request.getParameter("customerName");
        String type = request.getParameter("type");

        // ACCOUNT NO
        sb.append("<div class=\"form-group\">");
        sb.append("<label for=\"accountNo\">Account No:</label>");
        if (customerName != null) {
            if (customerName.equals("")) {
                sb.append("<input type=\"text\" class=\"form-control\" id=\"accountNo\" "
                        + "name=\"accountNo\" aria-describedby=\"accountNoHelp\" pattern=\"01-\\d{3}-\\d{4}\" "
                        + "placeholder=\"01-XXX-XXXX\" title=\"Enter your account number\" >");
            } else {
                sb.append("<input type=\"text\" class=\"form-control\" id=\"accountNo\" "
                        + "name=\"accountNo\" aria-describedby=\"accountNoHelp\" pattern=\"01-\\d{3}-\\d{4}\" "
                        + "placeholder=\"01-XXX-XXXX\" title=\"Enter your account number\" value=\'" + accountNo + "'>");
            }
        } else {
            sb.append("<input type=\"text\" class=\"form-control\" id=\"accountNo\" "
                    + "name=\"accountNo\" aria-describedby=\"accountNoHelp\" placeholder=\"01-XXX-XXXX\" title=\"Enter your account number\" >");
        }
        sb.append("<small id=\"accountNoHelp\" class=\"form-text text-muted\">Your unique account number.</small>");
        sb.append("</div>");

        // CUSTOMER NAME
        sb.append("<div class=\"form-group\">");
        sb.append("<label for=\"customerName\">Customer Name:</label>");
        if (customerName != null) {
            if (customerName.equals("")) {
                sb.append("<input type=\"text\" class=\"form-control\" id=\"customerName\" name=\"customerName\" aria-describedby=\"customerNameHelp\" placeholder=\"e.g. John Smith\" title=\"Enter your full name\" >");
            } else {
                sb.append("<input type=\"text\" class=\"form-control\" id=\"customerName\" name=\"customerName\" aria-describedby=\"customerNameHelp\" placeholder=\"e.g. John Smith\" title=\"Enter your full name\" value=\'" + customerName + "'>");
            }
        } else {
            sb.append("<input type=\"text\" class=\"form-control\" id=\"customerName\" name=\"customerName\" aria-describedby=\"customerNameHelp\" placeholder=\"e.g. John Smith\" title=\"Enter your full name\" >");
        }
        sb.append("<small id=\"customerNameHelp\" class=\"form-text text-muted\">Enter your full name.</small>");
        sb.append("</div>");

        // TYPE OF ACCOUNT
        sb.append("  <div class=\"form-group\">");
        sb.append("    <label for=\"type\">Type of Account:</label>");
        sb.append("    <select class=\"form-control\" id=\"type\" name=\"type\">");
        if ("Checking".equals(type)) {
            sb.append("      <option value=\"Checking\">Checking</option>");
            sb.append("      <option value=\"Savings\">Savings</option>");
        } else {
            sb.append("      <option value=\"Checking\">Checking</option>");
            sb.append("      <option value=\"Savings\">Savings</option>");
        }
        sb.append("   </select>");
        sb.append("  </div>");

        sb.append("<button id=\"btnSubmit\" type=\"submit\" class=\"btn btn-primary btn-block\">Submit</button>");
        sb.append("</fieldset>");
        sb.append("</form>");
        sb.append("</div>");
       
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

}
