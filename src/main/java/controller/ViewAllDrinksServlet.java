package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import model.ListCustomer;
//import model.Customer;
import model.Drink;
import model.Order;

/**
 * Servlet implementation class ViewAllDrinksServlet
 */
@WebServlet("/viewAllDrinksServlet")
public class ViewAllDrinksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllDrinksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//ListCustomerHelper dao = new ListCustomerHelper();
		OrderHelper ohdao = new OrderHelper();
		DrinkHelper dhdao = new DrinkHelper();
		
		List<Drink> allDrinks = dhdao.showAllDrinks();
		request.setAttribute("allDrinks", allDrinks);
	
		if (allDrinks.isEmpty()) {
			System.out.println("No drinks currently found in Drinks table");
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
		
		// once verified that Drinks table is not empty can move all to get
		// rest of attributes from other tables in DB. 
		// ??? may not need these, but setting attributes in case need anything
		// ??? from these other tables
		//List<Customer> allCustomers = dao.showAllCustomers();
		//List<ListCustomer> allCustomers = dao.showAllCustomers();
		//request.setAttribute("allCustomers", allCustomers);
		List<Order> allOrders = ohdao.showAllOrders();
		request.setAttribute("allOrders", allOrders);
		
		getServletContext().getRequestDispatcher("/all-drinks-list.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
