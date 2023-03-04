/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Feb 26, 2023
* Mini-Project - with Kassidi Freel 
*/
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import controller.DrinkHelper;
import controller.ListCustomerHelper;


/**
 * Order class - blueprint for creating an instance of Order 
 * class object/entity to put into mySQL schema: coffee_order_management_db
 * tables.  
 */
// Will uncomment below annotation lines once basics working & ready to add join
@Entity
@Table(name="ORDERS")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private int orderID;
	
	//each Order object can only have one customer,
	//but each Customer object can have many orders it is a ManyToOne
	//@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	//@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID")
	//@JoinColumn(name="customerID", referencedColumnName="CUSTOMER_ID")
	//@JoinColumn(name="customerID", referencedColumnName="CUSTOMERID")
	//@ManyToOne(fetch=FetchType.EAGER, targetEntity=model.Customer.class, cascade=CascadeType.MERGE)
	//private Customer customer;
	//@Column(name="CUSTOMER_ID")
	//@JoinTable(name="customers", joinColumns= @JoinColumn(name="ORDER_ID"), inverseJoinColumns = @JoinColumn(name="CUSTOMER_ID"))
	//@JoinTable(name="ORDER_CUST_IDS", joinColumns= @JoinColumn(name="ORDER_ID"), inverseJoinColumns = @JoinColumn(name="CUSTOMER_ID"))
	//@Column(name="CUSTOMER_ID")
	
	//@ManyToOne//(fetch=FetchType.EAGER, targetEntity=model.Customer.class, cascade=CascadeType.MERGE)
	//@JoinColumn(name="customerID", referencedColumnName="CUSTOMERID")
	//@JoinColumn(name="CUSTOMERID", referencedColumnName="customerID")
	//@ManyToOne(cascade=CascadeType.MERGE, targetEntity=model.Customer.class, fetch=FetchType.EAGER)
	
	//@Column(name="CUSTOMER_ID")
	@Column(name="customerID")
	private int customerID;
	@ManyToOne(cascade=CascadeType.ALL, targetEntity=model.ListCustomer.class, fetch=FetchType.EAGER)
	//@ManyToOne Customer customer;
	//private Customer customer;
	private ListCustomer customer;
	
	// - changed to double to stay consistent w/ Drink class 
	// - changed name from price to TOTAL_PRICE to be more descriptive
	// ???- mark column as 'Transient' since it's a calculated field/instance variable
	// based on other instance variables
	//@Transient
	@Column(name="TOTAL_PRICE")
	private double totalPrice;
	
	// ??? set LocalDate date as current date, here, in constructor, 
	// ??? in getter/setter method or using servlet???
	@Column(name="ORDER_DATE")
	private LocalDate date;
	
	// ArrayList to hold list of any Drink class objects/entities for each 
	// Order class object/entity
	// ???- not sure which version of OneToMany to use for Drink objects
	// one Order object can have many Drink objects
	//@OneToMany(mappedBy="DRINK_ID", fetch=FetchType.EAGER, targetEntity=model.Drink.class, cascade=CascadeType.ALL, orphanRemoval=true)
	//@JoinColumn(name="ORDER_ID")
	//@OneToMany(mappedBy="DRINK", targetEntity=model.Drink.class, cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	//private Drink drink;
	//@Column(name="drinkList")
	//@JoinTable(name="ORDER_DRINK_IDS", joinColumns= @JoinColumn(name="ORDER_ID"), inverseJoinColumns = @JoinColumn(name="DRINK_ID"))
	//@JoinColumn(name="DRINK_ID")
	//@OneToMany(targetEntity=model.Drink.class, cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private ArrayList<Drink> drinkList;
	//private ArrayList<Drink> drinkList = new ArrayList<>();
	//@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	//@JoinTable(name="ORDER_DRINK_IDS", joinColumns= @JoinColumn(name="ORDER_ID"), inverseJoinColumns = @JoinColumn(name="DRINK_ID"))
	// ??? or  - ?does a DRINK_ID need to be created in Drink class??? 
	// ??? went ahead & created a drinkID attribute/field in Drink class
	//@OneToMany(targetEntity=Drink.class, mappedBy="order")
	//@MapKey(name="DRINK_ID")

	
	// Constructors
	/**
	 * Default - no args constructor
	 */
	public Order() {
		super();
	}
	//??? Alternative Order object created first & then customer attached??
	//??? -since Drink objects also attached to Order relationship wise???
	
	//??? Primary constructor as Customer created 1st, then Order
	//??? created after pass in unique customerID assigned when 
	//??? Customer created rest such as int OrderID, double totalPrice, 
	//??? LocalDate date, ArrayList<Drink> drinkList, would be 
	//??? assigned values when original Order object is created -
	//??? - so would not be fed in as parameter/args either???
	//??? -LocalDate date set when constructor initially called??
	/**
	 * Non-default constructor - takes only customerID args 
	 * @param customerID
	 */
	public Order(int customerID) {
		super();
		this.customerID = customerID;
	}
	
	//??? Remove/Change any constructor's w/ totalPrice as an arg 
	//??? since won't ever be fed in when Order object created
	//??? d/t totalPrice is calculated from adding up prices of
	//??? total number of Drink objects in drinkList arrayList
	//??? - would change how this.totalPrice set using the calculation
	//??? as loop through arrayList drinkList inside of the setter???
	/**
	 * Non-default constructor - may not need since price would be calculated/set
	 * based on ArrayList<Drink> drinklist contents
	 * @param customerID
	 * @param totalPrice
	 */
	public Order(int customerID, double totalPrice) {
		super();
		this.customerID = customerID;
		this.totalPrice = totalPrice;
		//???this.totalPrice = getTotalPrice();
	}
	
	/**
	 * ?Primary Non-default constructor when new order created & 1st Drink
	 * object passed in, along w/ localDate at that time. 
	 * @param customerID
	 * @param drink
	 * @param date
	 */
	public Order(int customerID, Drink drink, LocalDate date) {
		super();
		this.customerID = customerID;
		// add drink to ArrayList<Drink> drinkList
		this.drinkList = new ArrayList<Drink>();
		drinkList.add(drink);
		this.totalPrice = calcTotalPrice(drinkList);
		//???Should this be done in setTotalPrice() method? passing in drinkList???
		//???this.totalPrice = getTotalPrice(); versus using calcTotalPrice() method??
		this.date = date;
	}
	
			
	/**
	 * Non-default constructor - may not need since price would be calculated/set
	 * based on ArrayList<Drink> drinklist contents
	 * @param customerID
	 * @param totalPrice
	 * @param drinkList
	 */
	public Order(int customerID, double totalPrice, ArrayList<Drink> drinkList) {
		super();
		this.customerID = customerID;
		this.totalPrice = totalPrice;
		this.drinkList = drinkList;
	}

	/**
	 * Non-default constructor - may not need since price would be calculated/set
	 * based on ArrayList<Drink> drinklist contents & date would be set to date at time
	 * Order object/entity is created
	 * @param customerID
	 * @param totalPrice
	 * @param date
	 * @param drinkList
	 */
	public Order(int customerID, double totalPrice, LocalDate date, ArrayList<Drink> drinkList) {
		super();
		this.customerID = customerID;
		this.totalPrice = totalPrice;
		this.date = date;
		this.drinkList = drinkList;
	}

	/**
	 * Non-default constructor - may not need since price would be calculated/set
	 * based on ArrayList<Drink> drinklist contents & date would be set to date at time
	 * Order object/entity is created
	 * @param orderID
	 * @param customerID
	 * @param totalPrice
	 * @param date
	 * @param drinkList
	 */
	public Order(int orderID, int customerID, double totalPrice, LocalDate date, ArrayList<Drink> drinkList) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.totalPrice = totalPrice;
		this.date = date;
		this.drinkList = drinkList;
	}

	// Getters/Setters
	/**
	 * @return the orderID
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

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
	 * @return the price
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param price the price to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		//LocalDate orderDate = date.now();
		this.date = date;
	}

	/**
	 * @return the drinkList
	 */
	public ArrayList<Drink> getDrinkList() {
		return drinkList;
	}

	/**
	 * @param drinkList the drinkList to set
	 */
	public void setDrinkList(ArrayList<Drink> drinkList) {
		this.drinkList = drinkList;
	}

	// Helper methods
//	@Override
//	public String toString() {
//		return "Order [orderID=" + orderID + ", customerID=" + customerID + ", totalPrice=" + totalPrice + ", date=" + date + "]";
//	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customerID=" + customerID + ", totalPrice=" + totalPrice + ", date="
				+ date + ", drinkList=" + drinkList + "]";
	}
	
	
	public String displayOrderDetails() {
		ListCustomerHelper dao = new ListCustomerHelper();
		int customerID = this.customerID;
		//Customer customer = dao.searchForCustomerById(customerID);
		//String customerDetails = customer.customerInfoDetails();
		ListCustomer customer = dao.searchForCustomerById(customerID);
		String customerDetails = customer.returnCustomerDetails();
		ArrayList<Drink> drinkList = this.drinkList;
		int orderID = this.orderID;
		LocalDate orderDate = this.date;
		double orderTotal = calcTotalPrice(drinkList);
		StringBuilder sb = new StringBuilder();
		sb.append("orderID=" + orderID + "; Order Date: " + orderDate + "; \ncustomerID= " + customerID + "; Customer Info: ");
		sb.append(customerDetails + "\n");
		sb.append("Drink(s): ");
		for (Drink drink : drinkList) {
			sb.append(drink.toString() + "\n");
		}
		sb.append("Order total: " + orderTotal);
		return sb.toString();
	}
	
	public String displayDrinkListDetails() {
		//ListCustomerHelper dao = new ListCustomerHelper();
		//int customerID = this.customerID;
		//Customer customer = dao.searchForCustomerById(customerID);
		//String customerDetails = customer.customerInfoDetails();
		ArrayList<Drink> drinkList = this.drinkList;
		int orderID = this.orderID;
		LocalDate orderDate = this.date;
		//double orderTotal = calcTotalPrice(drinkList);
		StringBuilder sb = new StringBuilder();
		sb.append("orderID=" + orderID + "; Order Date: " + orderDate + "; \nDrink(s): \n");
		for (Drink drink : drinkList) {
			sb.append(drink.toString() + "\n");
		}
		//sb.append("Order total: " + orderTotal);
		return sb.toString();
	}
	
	public String displayDrinkDetails(int drinkID) {
		DrinkHelper dhdao = new DrinkHelper();
		Drink thisDrink = dhdao.searchForDrinkById(drinkID);
		int orderID = this.orderID;
		LocalDate orderDate = this.date;
		StringBuilder sb = new StringBuilder();
		sb.append("orderID=" + orderID + "; Order Date: " + orderDate + "; \nDrink: ");
		sb.append(thisDrink.toString());
		//for (Drink drink : drinkList) {
		//	sb.append(drink.toString() + "\n");
		//}
		//sb.append("Order total: " + orderTotal);
		return sb.toString();
	}

	public void addDrinkToList(Drink drinkToAdd) {
		this.drinkList.add(drinkToAdd);
		
	}

	/**
	 * @param price the price to set
	 */
	public double calcTotalPrice(ArrayList<Drink> drinkList) {
	//public void setTotalPrice(double totalPrice) {
		// iterate through this Order object's drinkList to 
		// sum the basePrices of all Drink objects in ArrayList
		// to calculate the totalPrice for order;
		// Initialize variable to hold totalPrice to 0.
		double totalPrice = 0;
		for (Drink drink : drinkList) {
			totalPrice += drink.getBasePrice();
		}
		return totalPrice;
	}

}
