package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCustomer;

/**
 * Servlet implementation class editCustomerServlet
 */
@WebServlet("/editCustomerServlet")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListCustomerHelper dao = new ListCustomerHelper();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		ListCustomer CustomerToUpdate = dao.searchForCustomerById(tempId);
		CustomerToUpdate.setFirstName(firstName);
		CustomerToUpdate.setLastName(lastName);
		CustomerToUpdate.setPhoneNumber(phoneNumber);		
		dao.updateCustomer(CustomerToUpdate);

		getServletContext().getRequestDispatcher("/viewAllCustomersServlet").forward(request, response);


	}

}