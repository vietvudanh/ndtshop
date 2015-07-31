package fu.project.NDTShop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

	private ServletContext context;
	String[] excludeURI = null;
	
    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    	context = null;
    	this.excludeURI = "html,css,css.map,js,jpg,png,/,login,logout,register".split(",");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();

		// pass the request along the filter chain
		this.context.log("Requested Resource::"+uri);
        
        HttpSession session = req.getSession(false);
        Object user = null;
        if(session != null){
        	user = session.getAttribute("user");
        }
        if(session == null || user == null && !excludeAuthenticate(uri) ){
            this.context.log("Unauthorized access request");
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }
        else{
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
	
	private boolean excludeAuthenticate(String uri){
		String uriWithoutContext = uri.replace(this.context.getContextPath(), "");
		for (String string : excludeURI) {
			if(uriWithoutContext.endsWith(string)){
				return true;
			}
		}
		return false;
	}

}
