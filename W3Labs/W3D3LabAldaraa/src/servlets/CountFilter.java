package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CountFilter
 */
@WebFilter(description = "CountFilter", urlPatterns = { "/*" })
public class CountFilter implements Filter {
	private int hitCount;

	/**
	 * Default constructor.
	 */
	public CountFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// System.out.println("Total Hit Count for the webapp is: " + ++hitCount);

		HttpServletRequest myRequest = (HttpServletRequest) request;
		HttpSession session = myRequest.getSession(true);

//		String count = (String)session.getAttribute("Counter");
		if (session.getAttribute("Counter") != null)
			session.setAttribute("Counter", (Integer.parseInt(session.getAttribute("Counter").toString())+1));
		else
			session.setAttribute("Counter", "1");

		System.out.println("Total Hit Count for the webapp is: " + hitCount);
		// pass the request along the filter chain
		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.hitCount++;
	}

}
