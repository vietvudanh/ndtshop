package fu.project.NDTShop.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fu.project.NDTShop.dao.ProductDAO;
import fu.project.NDTShop.model.Product;

/**
 * Servlet implementation class AdminProductController
 */
@WebServlet("/AdminProductController")
public class AdminProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO dao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProductController() {
        super();
        dao = new ProductDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// might need pagination on this
		ArrayList<Product> products = (ArrayList<Product>) dao.getList();
		request.setAttribute("products", products);
		request.getRequestDispatcher("/WEB-INF/view/admin/products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
