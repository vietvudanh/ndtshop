package fu.project.NDTShop.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fu.project.NDTShop.dao.CustomerDAO;
import fu.project.NDTShop.model.Customer;

/**
 * Servlet implementation class RegisterCustomerController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerDAO dao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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
		if (session != null && session.getAttribute("user") != null){
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Customer c = dao.getCustomerByUsername(username);
		
		if (c != null){
			String message = "Username already exists!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
		}
		else{
			Customer customer = new Customer("", username, password, name, new Date(0), "", email, "", "", "", new Date(0));
			if(dao.addCustomerRegister(customer)){
				request.setAttribute("customername", customer.getCustomername());
				request.getRequestDispatcher("/WEB-INF/view/register_success.jsp").forward(request, response);
			}
			else{
				String message = "Cannot add user!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
			}
		}
	}

}
