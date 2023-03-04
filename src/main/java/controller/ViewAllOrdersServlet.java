/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Mar 2, 2023
* Mini-Project - with Kassidi Freel 
*/

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.Drink;
import model.Order;

/**
 * Servlet implementation class ViewAllOrdersServlet - Servlet called
 * by AddOrdersServlet - which created a new Order object/entity
 * This servlet will then direct to all-orders-list.jsp to display
 * all Orders in DB with its details to allow user to select one
 * or return to main page.
 */
@WebServlet("/viewAllOrdersServlet")
public class ViewAllOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ListCustomerHelper dao = new ListCustomerHelper();
		OrderHelper ohdao = new OrderHelper();
		DrinkHelper dhdao = new DrinkHelper();
		
		List<Order> allOrders = ohdao.showAllOrders();
		request.setAttribute("allOrders", allOrders);
	
		if (allOrders.isEmpty()) {
			System.out.println("No orders currently found in Orders table");
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
		
		// once verified that Orders table is not empty can move all to get
		// rest of attributes from other tables in DB. 
		List<Customer> allCustomers = dao.showAllCustomers();
		request.setAttribute("allCustomers", allCustomers);
		List<Drink> allDrinks = dhdao.showAllDrinks();
		request.setAttribute("allDrinks", allDrinks);
		
		getServletContext().getRequestDispatcher("all-orders-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
