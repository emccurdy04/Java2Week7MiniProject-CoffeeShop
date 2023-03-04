package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCustomer;
//import model.Customer;


/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		if (firstName.isEmpty() || lastName.isEmpty() ||phoneNumber.isEmpty() || firstName == null || lastName == null || phoneNumber == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			ListCustomer li = new ListCustomer(firstName, lastName, phoneNumber);
			//Customer li = new Customer(firstName, lastName, phoneNumber);
			ListCustomerHelper dao = new ListCustomerHelper();
			dao.insertCustomer(li);
			//??? not sure if this will work
			//??? set customer attribute as well as coffeeSize/coffeeType to be sent 
			//??? to addOrdersServlet after new customer created
			//String coffeeSize = request.getParameter("coffeeSizeInput");
			//String coffeeType = request.getParameter("coffeeTypeInput");
			request.setAttribute("customer", li);
			//request.setAttribute("coffeeSize", coffeeSize);
			//request.setAttribute("coffeeType", coffeeType);
			//getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			getServletContext().getRequestDispatcher("addOrdersServlet").forward(request, response);
		}
	}

}
