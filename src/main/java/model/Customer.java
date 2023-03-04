/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Feb 24, 2023
* Mini-Project - with Kassidi Freel 
*/
package model;

import java.util.ArrayList;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;

/**
 * Customer class - blueprint for creating and instance of Customer
 * class object/entity to put into mySQL schema: coffee_order_management_db
 * tables.  
 */
//@Entity
//@Table(name="Customers")
//@Table(name="CustomersV1")
public class Customer {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="CUSTOMERID")
	private int customerID;
	//@Column(name="FIRSTNAME")
	private String firstName;
	//@Column(name="LASTNAME")
	private String lastName;
	//@Column(name="PHONENUMBER")
	private String phoneNumber;

	// Commented out while doing trial of using ListCustomer version 
	// Will add in the joins later once sure just the simple customer table creation
	// is working for both of us
	//@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	// ???Not sure if need this next @JoinTable line of code? 
	//@JoinTable(name="CUSTOMER_ORDER_IDS", joinColumns= @JoinColumn(name="CUSTOMER_ID"), inverseJoinColumns = @JoinColumn(name="ORDER_ID"))
	// ArrayList to hold list of any Orders class objects/entities for each 
	// Customer class object/entity
	//@JoinTable(name="CUSTOMER_ORDER_IDS", joinColumns= @JoinColumn(name="CUSTOMER_ID"), inverseJoinColumns = @JoinColumn(name="ORDER_ID"))
	//@OneToMany(mappedBy="CUSTOMER", targetEntity=model.Order.class, cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	//@OneToMany(mappedBy="customerID", targetEntity=model.Order.class, cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	//@OneToMany(mappedBy="customerID", targetEntity=model.Order.class, cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	//@OneToMany(mappedBy="orders", targetEntity=model.Order.class, cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	//@Column(name="CUST_ORDER_LIST")
	//@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private ArrayList<Order> orders = new ArrayList<>();

	//Constructors
	/**
	 * Default - no args constructor
	 */
	public Customer() {
		super();
	}

	/**
	 * Non-default constructor - takes all args except customerID & ArrayList<Orders>
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	public Customer(String firstName, String lastName, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		// uncomment below line once basics up & working
		//this.orders = getOrders();
	}

	/**
	 * Non-default constructor - takes all args except customerID
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param orders
	 */
	public Customer(String firstName, String lastName, String phoneNumber, ArrayList<Order> orders) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.orders = orders;
	}

	/**
	 * Non-default constructor - takes all args
	 * @param customerID
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param orders
	 */
	public Customer(int customerID, String firstName, String lastName, String phoneNumber, ArrayList<Order> orders) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.orders = orders;
	}

	
	// Getters/Setters
	/**
	 * @return the customerID
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the orders
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	// Helper methods
	public void addOrderToList(Order order) {
		this.orders.add(order);
	}
	
	// ??? decide on which of below two customer details to keep
	public String customerInfoDetails() {
		String firstName = this.firstName;
		String lastName = this.lastName;
		String formattedPhone = formatPhoneNum(this.phoneNumber);
		return lastName + ", " + firstName + "\n" + formattedPhone;
	}
	
	public String returnCustomerDetails( ) {
		//return fName + " " + lName + " "+ phoneNumber;
		return firstName + " " + lastName + " "+ phoneNumber;
	}
	
	private String formatPhoneNum(String phoneNumber) {
		String phoneNumDigits = phoneNumber;
		// changed phoneNumber from int to String so no longer needed to cast int to String
		//String phoneNumDigits = Integer.toString(phoneNumber);
		String formattedPhoneNum = "";
		formattedPhoneNum += "(" + phoneNumDigits.substring(0,3) + ")" + phoneNumDigits.substring(3, 6) + "-" + phoneNumDigits.substring(6, phoneNumDigits.length());
		//System.out.println(formattedPhoneNum);
		return formattedPhoneNum;
	}
	
//	public String displayOrderList() {
//		ArrayList<Order> orders = this.orders;
//		StringBuilder sb = new StringBuilder();
//		sb.append("Customer Order List: \n");
//		for (Order order : orders) {
//			// may want to change to a specific formatted version rather than toString()
//			// method such as creating an Order class method ?displayOrder()
//			sb.append(order.toString() + "\n");
//		}
//		return sb.toString();
//	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
