/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Mar 2, 2023
* Mini-Project - with Kassidi Freel 
*/

package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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
 * Servlet implementation class AddOrdersServlet - This servlet
 * creates a new Order with 1st drink and customer info, then
 * directs to viewEditThisOrder page so order can be reviewed/
 * changed/added to 
 */
@WebServlet("/addOrdersServlet")
public class AddOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		
		String coffeeSize = request.getParameter("coffeeSizeInput");
		String coffeeType = request.getParameter("coffeeTypeInput");
		
		// create instance of helpers to be used throughout if/else if/else
		// to decrease redundant code
		//ListCustomerHelper dao = new ListCustomerHelper();
		OrderHelper ohdao = new OrderHelper();
		DrinkHelper dhdao = new DrinkHelper();
		LocalDate date = LocalDate.now();
		
		//?? need need way created to search for customerID via firstname, lastname, 
		//& phone number in ListCustomerHelper that returns a ListCustomer object rather
		// than a list - so can get customer info needed to created the order 
		//ListCustomer newCustomer = dao.searchForCustomerByNameNumber(firstName, lastname, phoneNumber);
		
		//int customerID = newCustomer.getId();
		
		// ???create variable to hold customer object - once verify doesn't already
		// ???exist? - should actually do this verification in AddCustomerServlet
		// ???then add order/drink Servlet(s) - ????
		// ??? If do change that to AddCustomerServelt, then get customer object
		// ??? from that Servlet? rather than getting name/number parameters above
		// ??? Then also don't need below if/else if/else statements re: creating
		// ??? customer object - then once have it can move on 
		//Customer customer;
		
		// ????
		//if (fName.isEmpty() || lName.isEmpty() ||phoneNumber.isEmpty() || fName == null || lName == null || phoneNumber == null) {
			//getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		//}
		if (firstName.isEmpty() || lastName.isEmpty() || firstName == null || lastName == null) {
			// return to main page if first/last name fields are empty/null
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else if (phoneNumber.isEmpty() || phoneNumber == null) {
			// if phoneNumber field empty/null put in a fake number & create customer
			String fakePhoneNumber = "515XXXZZZZ";
			//Customer newCustomer = new Customer(fName, lName, fakePhoneNumber);
			//ListCustomer newCustomer = new ListCustomer(firstName, lastName, fakePhoneNumber);
			//ListCustomerHelper dao = new ListCustomerHelper();
			//dao.insertCustomer(newCustomer);
			// ???if did leave above here once verified customer then moves on
			// to creating new Order & new Drink objects here - then should
			// move to page for viewing order/drinks in this order & selecting if want 
			// to edit order - add/delete/change drink in order ?customer info?
			// change options too???
			//int customerID = newCustomer.getCustomerID();
			//int customerID = newCustomer.getId();
			// create Drink object first passing in parameters from index page
			//using constructor: Drink(String drinkSize, String drinkType) 
			Drink newDrink = new Drink(coffeeSize, coffeeType);
			dhdao.createNewDrink(newDrink);
			//use constructor Order(int customerID, Drink drink, LocalDate date)
			//Order newOrder = new Order(customerID, newDrink, date);
			//use constructor: Order(String firstName, String lastName, String phoneNumber, Drink drink, LocalDate date)
			Order newOrder = new Order(firstName, lastName, fakePhoneNumber, newDrink, date);
			ohdao.createNewOrder(newOrder);
			// ??? does the newDrink need to be inserted into table if used in 
			// ??? constructor to create the newOrder???
			// ???Now directed to page to viewEditThisOrderServelt - ?would have to 
			// somehow pass this objects Order ID to the Servlet or .jsp to do this
			//getServletContext().getRequestDispatcher("/viewEditThisOrderServlet").forward(request, response);
			// Direct to page that displays all Order objects w/ their details
			// to select if want to add/edit/delete drinks 
			getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
			
		} else {
			//ListCustomer newCustomer = new ListCustomer(firstName, lastName, phoneNumber);
			//Customer newCustomer = new Customer(fName, lName, phoneNumber);
			//ListCustomerHelper dao = new ListCustomerHelper();
			//dao.insertCustomer(newCustomer);
			// ???if did leave above here once verified customer then moves on
			// to creating new Order & new Drink objects here
			// ???if did leave above here once verified customer then moves on
			// to creating new Order & new Drink objects here - then should
			// move to page for viewing order/drinks in this order & selecting if want 
			// to edit order - add/delete/change drink in order ?customer info?
			// change options too???
			//int customerID = newCustomer.getCustomerID();
			//int customerID = newCustomer.getId();
			// create Drink object first passing in parameters from index page
			//using constructor: Drink(String drinkSize, String drinkType) 
			Drink newDrink = new Drink(coffeeSize, coffeeType);
			dhdao.createNewDrink(newDrink);
			//use constructor Order(int customerID, Drink drink, LocalDate date)
			//Order newOrder = new Order(customerID, newDrink, date);
			//use constructor: Order(String firstName, String lastName, String phoneNumber, Drink drink, LocalDate date)
			Order newOrder = new Order(firstName, lastName, phoneNumber, newDrink, date);
			ohdao.createNewOrder(newOrder);
			// ???Now directed to page to viewEditThisOrderServlet- ?would have to 
			// somehow pass this objects Order ID to the Servlet or .jsp to do this
			//getServletContext().getRequestDispatcher("/viewEditThisOrderServlet").forward(request, response);
			// Direct to page that displays all Order objects w/ their details
			// to select if want to add/edit/delete drinks 
			getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
		}
		
	}
}
