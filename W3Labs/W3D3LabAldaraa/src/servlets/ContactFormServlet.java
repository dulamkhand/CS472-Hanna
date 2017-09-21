package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactFormServlet
 */
@WebServlet(description = "ContactFormServlet", urlPatterns = { "/contact" })
public class ContactFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int hitCount;
    
    public ContactFormServlet() {
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
		sb.append("<a class=\"navbar-brand\" href=\"index.html\">CS472 ::: W3D2 Lab</a>");
		sb.append("<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarsExampleDefault\" aria-controls=\"navbarsExampleDefault\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
		sb.append("<span class=\"navbar-toggler-icon\"></span>");
		sb.append("</button>");            
		sb.append("</nav>");
		sb.append("<div class=\"container\">");
		sb.append("<form id=\"formCustomerContact\" method=\"post\" action=\"processContact\">");
		sb.append("<fieldset>");
		sb.append("<legend>Customer Contact Form</legend>");
		
		// Check if msg exist
		Object objErrMsgs = request.getAttribute("errMsgs");
		if(objErrMsgs != null) {
			String errorMsgs = (String) objErrMsgs;
			sb.append("<div><p>");
			sb.append(errorMsgs);
			sb.append("</p></div>");
		}				
		// read and write existing values
		String customerName = request.getParameter("customerName");
		String gender = request.getParameter("radioGender");
		String category = request.getParameter("ddlCategory");
		String message = request.getParameter("message");		
		
		sb.append("<div class=\"form-group\">");
		sb.append("<label for=\"customerName\">*Name:</label>");
		if(customerName != null) {
			if(customerName.equals("")) {
				sb.append("<input type=\"text\" class=\"form-control\" id=\"customerName\" name=\"customerName\" aria-describedby=\"customerNameHelp\" placeholder=\"e.g. John Smith\" title=\"Enter your full name\" >");
			} else {
				sb.append("<input type=\"text\" class=\"form-control\" id=\"customerName\" name=\"customerName\" aria-describedby=\"customerNameHelp\" placeholder=\"e.g. John Smith\" title=\"Enter your full name\" value=\'" + customerName + "'>");
			}
		} else {
			sb.append("<input type=\"text\" class=\"form-control\" id=\"customerName\" name=\"customerName\" aria-describedby=\"customerNameHelp\" placeholder=\"e.g. John Smith\" title=\"Enter your full name\" >");
		}
		sb.append("<small id=\"customerNameHelp\" class=\"form-text text-muted\">Enter your full name.</small>");
		sb.append("</div>");
		
		sb.append("<label>*Gender:</label><br/>");
		sb.append("<label class=\"custom-control custom-radio\">");
		sb.append("  <input id=\"radioGenderMale\" name=\"radioGender\" type=\"radio\" class=\"custom-control-input\" value='male'");
		if(gender != null) {
			if(gender.equals("male")) {
				sb.append(" checked>");
			}
			else {
				sb.append(">");
			}
		} else {
			sb.append("  <input id=\"radioGenderMale\" name=\"radioGender\" type=\"radio\" class=\"custom-control-input\" value='male'>");
		}
		sb.append("  <span class=\"custom-control-indicator\"></span>");
		sb.append("  <span class=\"custom-control-description\">Male</span>");
		sb.append("</label>");
		sb.append("<label class=\"custom-control custom-radio\">");
		sb.append("  <input id=\"radioGenderFemale\" name=\"radioGender\" type=\"radio\" class=\"custom-control-input\" value='female'");
		if(gender != null) {
			if(gender.equals("female")) {
				sb.append(" checked>");
			} else {
				sb.append(">");
			}
		} else {
			sb.append("  <input id=\"radioGenderFemale\" name=\"radioGender\" type=\"radio\" class=\"custom-control-input\" value='female'>");
		}
		sb.append("  <span class=\"custom-control-indicator\"></span>");
		sb.append("  <span class=\"custom-control-description\">Female</span>");
		sb.append("</label>");	
	
		sb.append("  <div class=\"form-group\">");
		sb.append("    <label for=\"ddlCategory\">*Category:</label>");
		sb.append("    <select class=\"form-control\" id=\"ddlCategory\" name=\"ddlCategory\">");
		if(category == null) {
			sb.append("      <option value=\"null\">Select...</option>");
			sb.append("      <option value=\"feedback\">Feedback</option>");
			sb.append("      <option value=\"inquiry\">Inquiry</option>");
			sb.append("      <option value=\"complaint\">Complaint</option>");
		} else {
			switch (category) {
				case "null":
					sb.append("      <option selected value=\"null\">Select...</option>");
					sb.append("      <option value=\"feedback\">Feedback</option>");
					sb.append("      <option value=\"inquiry\">Inquiry</option>");
					sb.append("      <option value=\"complaint\">Complaint</option>");	
					break;
				case "feedback":
					sb.append("      <option value=\"null\">Select...</option>");
					sb.append("      <option selected value=\"feedback\">Feedback</option>");
					sb.append("      <option value=\"inquiry\">Inquiry</option>");
					sb.append("      <option value=\"complaint\">Complaint</option>");		
					break;
				case "inquiry":
					sb.append("      <option value=\"null\">Select...</option>");
					sb.append("      <option value=\"feedback\">Feedback</option>");				
					sb.append("      <option selected value=\"inquiry\">Inquiry</option>");
					sb.append("      <option value=\"complaint\">Complaint</option>");	
					break;
				case "complaint":
					sb.append("      <option value=\"null\">Select...</option>");
					sb.append("      <option value=\"feedback\">Feedback</option>");
					sb.append("      <option value=\"inquiry\">Inquiry</option>");				
					sb.append("      <option selected value=\"complaint\">Complaint</option>");
					break;
				default:
					break;
			}
		}
		sb.append("   </select>");
		sb.append("  </div>");				
		
		sb.append("<div class=\"form-group\">");
		sb.append("<label for=\"message\">*Message:</label>");
		if(message != null) {
			if(message.equals("")) {
				sb.append("<textarea class=\"form-control\" id=\"message\" name=\"message\" rows=\"3\" ></textarea>");
			} else {
				sb.append("<textarea class=\"form-control\" id=\"message\" name=\"message\" rows=\"3\">" + message + "</textarea>");
			}
		} else {
			sb.append("<textarea class=\"form-control\" id=\"message\" name=\"message\" rows=\"3\" ></textarea>");
		}
		sb.append("</div>");
		
		sb.append("<button id=\"btnSubmit\" type=\"submit\" class=\"btn btn-primary btn-block\">Submit</button>");
		sb.append("</fieldset>");
		sb.append("</form>");
		sb.append("</div>");
		
		// Display Hit Counts
		sb.append("<div class=\"container\"><br/>");
		sb.append("<span class=\"text-muted\">Hit Count for this page: " + this.hitCount +"</span><span style=\"float:right;\" class=\"text-muted\">Total Hit Count for the entire WebApp: --</span>");
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

}
