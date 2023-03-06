package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Drink;
import model.Order;

/**
 * Servlet implementation class ViewEditThisDrinkServlet
 */
@WebServlet("/viewEditThisDrinkServlet")
public class ViewEditThisDrinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEditThisDrinkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		OrderHelper ohdao = new OrderHelper();
		DrinkHelper dhdao = new DrinkHelper();
		
		//String path = "/view-edit-thisDrink.jsp";
		String path = "/view-edit-thisOrder.jsp";
		
		String act = request.getParameter("doThisToDrink");
				
		//Integer tempOrderId = Integer.parseInt(request.getParameter("orderID"));
		
		// depending on selection of user OrderNavigationServlet will by default
		// re-display the selected order with drink/customer details - unless
		// user selected delete order then it routes to ViewAllOrdersServlet
		// after Order/Customer/Drink deletion
		//String path="/viewEditThisOrderServlet";
		
		if (act == null) {
			//no button selected - refresh page
			//getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
			path="/view-edit-thisDrink.jsp";
//		} else if (act.equalsIgnoreCase("deleteDrinkFromOrder")) {
//			try {
//				Integer tempOrderId = Integer.parseInt(request.getParameter("orderID"));
//				Integer tempDrinkId = Integer.parseInt(request.getParameter("drinkID"));
//				Drink drinkToDelete = dhdao.searchForDrinkById(tempDrinkId);
//				dhdao.deleteDrink(drinkToDelete);
//				Order orderToEdit = ohdao.searchForOrderById(tempOrderId);
//				
//				// after update Order object then refresh drinkList 
//				// & recalculate - totalPrice
//				ArrayList<Drink> drinkListToEdit = orderToEdit.getDrinkList();
//				request.setAttribute("drinkListToEdit", drinkListToEdit);
//				double newTotalPrice = orderToEdit.calcTotalPrice(drinkListToEdit);
//				orderToEdit.setTotalPrice(newTotalPrice);
//				//Integer tempCustId = orderToEdit.getCustomerID();
//				//Customer customerToEdit = dao.searchForCustomerById(tempCustId);
//				//ListCustomer customerToEdit = dao.searchForCustomerById(tempCustId);
//				//request.setAttribute("customerToEdit", customerToEdit);
//				//Integer tempCustId = orderToDelete.getCustomerID();
//				//ArrayList<Drink> drinkListToDelete = orderToDelete.getDrinkList();
//				//???can't delete customer at this point since a customer can have 
//				//???more than one order - would have to do through a customer delete
//				//???that then removes all associated orders & drinks for that customer
//				//Customer customerToDelete = dao.searchForCustomerById(tempCustId);
//				//dao.deleteCustomer(customerToDelete);
//				//for (Drink drink : drinkListToDelete) {
//				//	dhdao.deleteDrink(drink);
//				//}
//				//ohdao.deleteOrder(orderToDelete);
//				ohdao.updateOrder(orderToEdit);
//				request.setAttribute("orderToEdit", orderToEdit);
//				// refresh page
//				path="/view-edit-thisOrder.jsp";	
//			} catch (NumberFormatException e) {
//				System.out.println("Forgot to select a drink to delete from order");
//			} //finally {
//				//route to ViewAllOrdersServlet after to display all remaining orders
//				//in table once completed order delete
//				//getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
//				//path="/viewAllOrdersServlet";
//				//path="/view-edit-thisOrder.jsp";
//			//}
		} else if (act.equalsIgnoreCase("editDrink")) {
			try {
				Integer tempOrderId = Integer.parseInt(request.getParameter("orderID"));
				Integer tempDrinkId = Integer.parseInt(request.getParameter("drinkID"));
				Drink drinkToEdit = dhdao.searchForDrinkById(tempDrinkId);
				//request.setAttribute("drinkToEdit", drinkToEdit);
				String coffeeSize = request.getParameter("coffeeSizeInput");
				String coffeeType = request.getParameter("coffeeTypeInput");
				//request.setAttribute("drinkToEdit", drinkToEdit);
				drinkToEdit.setDrinkSize(coffeeSize);
				drinkToEdit.setDrinkType(coffeeType);
				drinkToEdit.setBasePrice(coffeeSize);
				dhdao.updateDrink(drinkToEdit);
				Order orderToEdit = ohdao.searchForOrderById(tempOrderId);
				//ohdao.updateOrder(orderToEdit);
				//request.setAttribute("orderToEdit", orderToEdit);
				// get updated Order object's drinkListToEdit after drink edited				
				ArrayList<Drink> drinkListToEdit = orderToEdit.getDrinkList();
				//request.setAttribute("drinkListToEdit", drinkListToEdit);
				double newTotalPrice = orderToEdit.calcTotalPrice(drinkListToEdit);
				orderToEdit.setTotalPrice(newTotalPrice);
				ohdao.updateOrder(orderToEdit);
				request.setAttribute("drinkToEdit", drinkToEdit);
				request.setAttribute("orderToEdit", orderToEdit);
				// refresh page
				path="/view-edit-thisOrder.jsp";
				//path="/view-edit-thisDrink.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to edit drink in order");
			}
//		} else if (act.equalsIgnoreCase("addDrinkToOrder")) {
//			try {
//				Integer tempOrderId = Integer.parseInt(request.getParameter("orderID"));
//				String coffeeSize = request.getParameter("coffeeSizeInput");
//				String coffeeType = request.getParameter("coffeeTypeInput");
//				Order orderToEdit = ohdao.searchForOrderById(tempOrderId);
//				request.setAttribute("orderToEdit", orderToEdit);
//				// create Drink object first passing in parameters from index page
//				//using constructor: Drink(String drinkSize, String drinkType) 
//				Drink newDrink = new Drink(coffeeSize, coffeeType);
//				dhdao.createNewDrink(newDrink);
//				orderToEdit.addDrinkToList(newDrink);
//				ArrayList<Drink> drinkListToEdit = orderToEdit.getDrinkList();
//				request.setAttribute("drinkListToEdit", drinkListToEdit);
//				double newTotalPrice = orderToEdit.calcTotalPrice(drinkListToEdit);
//				orderToEdit.setTotalPrice(newTotalPrice);
//				//Integer tempCustId = orderToEdit.getCustomerID();
//				//Customer customerToEdit = dao.searchForCustomerById(tempCustId);
//				//ListCustomer customerToEdit = dao.searchForCustomerById(tempCustId);
//				//request.setAttribute("customerToEdit", customerToEdit);
//				// get updated drinkListToEdit after new drink added to order
//				//ArrayList<Drink> drinkListToEdit = orderToEdit.getDrinkList();
//				//request.setAttribute("drinkListToEdit", drinkListToEdit);
//				ohdao.updateOrder(orderToEdit);
//				// refresh page
//				request.setAttribute("orderToEdit", orderToEdit);
//				path="/view-edit-thisOrder.jsp";
//			} catch (NumberFormatException e) {
//				System.out.println("Forgot to input details for drink to add to order");
//			}
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);	
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
