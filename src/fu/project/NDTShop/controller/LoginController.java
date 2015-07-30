package fu.project.NDTShop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fu.project.NDTShop.dao.CustomerDAO;
import fu.project.NDTShop.model.Customer;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CustomerDAO dao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        dao = new CustomerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
        	request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        }
        else{
        	request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Customer customer = dao.getCustomerByUsername(username);
		
		if(customer == null){
			String message = "User not exists";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}
		else if(!customer.getCustomerpassword().equals(password)){
			String message = "Wrong password";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}
		else if(customer.getCustomerpassword().equals(password)){
			HttpSession session = request.getSession();
			String customername = customer.getCustomername();
            session.setAttribute("user", username);
            session.setAttribute("customername", customername);
            //setting session to expire in 30 mins
            session.setMaxInactiveInterval(30*60);
            
            request.setAttribute("customername", customername);
            request.getRequestDispatcher("/WEB-INF/view/login_success.jsp").forward(request, response);
		}
		else{
			
		}
	}

}
