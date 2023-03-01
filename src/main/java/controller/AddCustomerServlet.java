package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import model.ListCustomer;
import model.Customer;


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
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		if (fName.isEmpty() || lName.isEmpty() ||phoneNumber.isEmpty() || fName == null || lName == null || phoneNumber == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			//ListCustomer li = new ListCustomer(fName, lName, phoneNumber);
			Customer li = new Customer(fName, lName, phoneNumber);
			ListCustomerHelper dao = new ListCustomerHelper();
			dao.insertCustomer(li);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
