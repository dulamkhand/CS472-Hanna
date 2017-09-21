package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int hitCount;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		hitCount=0;
		String customerName = request.getParameter("customerName");
		String gender = request.getParameter("radioGender");
		String category = request.getParameter("ddlCategory");
		String message = request.getParameter("message");
		response.setContentType("text/html");
		response.setBufferSize(8192);
		String output = this.generateLogoutPage();
		try (PrintWriter pw = response.getWriter()) {
			pw.println(output);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private String generateLogoutPage() {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>");
		sb.append("<html lang='en'>");
		sb.append("<head>");
		sb.append("    <meta charset='UTF-8'>");
		sb.append("    <meta name='viewport' content='width=device-width, initial-scale=1.0', shrink-to-fit=no\">");
		sb.append("    <meta http-equiv='X-UA-Compatible' content='ie=edge'>");
		sb.append("    <title>Customer Contact App - Thank you!</title>");
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
		sb.append("<a class=\"navbar-brand\" href=\"index.html\">CS472 ::: W3D2 Lab</a>");
		sb.append("<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarsExampleDefault\" aria-controls=\"navbarsExampleDefault\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
		sb.append("<span class=\"navbar-toggler-icon\"></span>");
		sb.append("</button>");            
		sb.append("</nav>");
		sb.append("<div class=\"container\">");	
		
		// Show current Date
		sb.append("<div class=\"container\"><br/>");
		sb.append("<span style=\"float:right;\" class=\"text-muted\">" + LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")) + "</span>");
		sb.append("</div>");
		
		sb.append("<p>");
		sb.append("<br/>");
		sb.append("<div class=\"card\">");
		sb.append(" <div class=\"card-header\">");
		sb.append("<h2>Thank you! Your message has been received as follows:</h2>");
		sb.append("  </div>");
		sb.append("  <div class=\"card-body\">");
		sb.append("  <p>Please feel free to <a href=\"contact\" class=\"card-link\">Contact Us</a> again</p>");
		sb.append("  </div>");
		sb.append("</div>");
		sb.append("</p>");
		
		// Display Hit Counts
		sb.append("<div class=\"container\">");
		sb.append("<span class=\"text-muted\">Hit Count for this page: " + this.hitCount +"</span><span style=\"float:right;\" class=\"text-muted\">Total Hit Count for the entire WebApp: --</span>");
		sb.append("</div>");		

		sb.append("</div>");
		sb.append("<footer class=\"footer\">");
		sb.append("<div class=\"container\">");
		sb.append("<span class=\"text-muted\">Aldarkhangai Chimed-Ochir ::: CS472-WAP</span><span style=\"float:right;\" class=\"text-muted\">&copy September 2017</span>");
		sb.append("</div>");
		sb.append("</footer>");      
		sb.append("</body>");
		sb.append("</html>");		
		
		return sb.toString(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
