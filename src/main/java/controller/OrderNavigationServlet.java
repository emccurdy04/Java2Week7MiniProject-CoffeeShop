/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Mar 2, 2023
* Mini-Project - with Kassidi Freel 
*/

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import model.Customer;
import model.Drink;
//import model.ListCustomer;
import model.Order;


/**
 * Servlet implementation class OrderNavigationServlet
 * Servlet called by all-orders-list.jsp after user selected an order
 * to be directed based on choice to edit/add to or delete selected order.
 * Directs to view-edit-thisOrder.jsp if selected edit/add to selected order.
 * Directs back to ViewAllOrdersServlet if nothing selected or after deletes
 * Order object/entity and all associated Drink objects/entities if user
 * selected an order to delete. 
 */
@WebServlet("/orderNavigationServlet")
public class OrderNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ListCustomerHelper dao = new ListCustomerHelper();
		OrderHelper ohdao = new OrderHelper();
		DrinkHelper dhdao = new DrinkHelper();
		
		String act = request.getParameter("doThisToOrder");
		//Integer tempId = Integer.parseInt(request.getParameter("orderID"));
		
		// depending on selection of user OrderNavigationServlet will by default
		// re-display the selected order with drink/customer details - unless
		// user selected delete order then it routes to ViewAllOrdersServlet
		// after Order/Customer/Drink deletion
		String path="/viewEditThisOrderServlet";
		
		if (act == null) {
			//no button selected - refresh page
			getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
		} else if (act.equalsIgnoreCase("deleteOrder")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("orderID"));
				Order orderToDelete = ohdao.searchForOrderById(tempId);
				ohdao.deleteOrder(orderToDelete);
				//Integer tempCustId = orderToDelete.getCustomerID();
				//ArrayList<Drink> drinkListToDelete = orderToDelete.getDrinkList();
				//???can't delete customer at this point since a customer can have 
				//???more than one order - would have to do through a customer delete
				//???that then removes all associated orders & drinks for that customer
				//Customer customerToDelete = dao.searchForCustomerById(tempCustId);
				//dao.deleteCustomer(customerToDelete);
				//for (Drink drink : drinkListToDelete) {
				//	dhdao.deleteDrink(drink);
				//}
				//ohdao.deleteOrder(orderToDelete);
				getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
			} catch (NumberFormatException e) {
				//??? may not need catch since also did an act == null above
				System.out.println("Forgot to select an order to delete");
			} //finally {
				//route to ViewAllOrdersServlet after to display all remaining orders
				//in table once completed order delete
				//getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
				//path="/viewAllOrdersServlet";
			//}
		} else if (act.equalsIgnoreCase("editOrder")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("orderID"));
				Order orderToEdit = ohdao.searchForOrderById(tempId);
				request.setAttribute("orderToEdit", orderToEdit);
				//Integer tempCustId = orderToEdit.getCustomerID();
				//Customer customerToEdit = dao.searchForCustomerById(tempCustId);
				//ListCustomer customerToEdit = dao.searchForCustomerById(tempCustId);
				//request.setAttribute("customerToEdit", customerToEdit);
				//ArrayList<Drink> drinkListToEdit = orderToEdit.getDrinkList();
				//request.setAttribute("drinkListToEdit", drinkListToEdit);
				//path="/view-edit-thisOrder.jsp";
				getServletContext().getRequestDispatcher("/view-edit-thisOrder.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an order to edit");
			}
		} else if (act.equalsIgnoreCase("addToOrder")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("orderID"));
				Order orderToEdit = ohdao.searchForOrderById(tempId);
				request.setAttribute("orderToEdit", orderToEdit);
				//Integer tempCustId = orderToEdit.getCustomerID();
				//Customer customerToEdit = dao.searchForCustomerById(tempCustId);
				//ListCustomer customerToEdit = dao.searchForCustomerById(tempCustId);
				//request.setAttribute("customerToEdit", customerToEdit);
				//ArrayList<Drink> drinkListToEdit = orderToEdit.getDrinkList();
				//request.setAttribute("drinkListToEdit", drinkListToEdit);
				//path="/view-edit-thisOrder.jsp";
				getServletContext().getRequestDispatcher("/view-edit-thisOrder.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an order to add drinks to");
			}
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

}
