/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Feb 26, 2023
* Mini-Project - with Kassidi Freel 
*/
package model;

import java.time.LocalDate;
import java.util.ArrayList;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.OneToMany;

/**
 * Order class - blueprint for creating and instance of Order 
 * class object/entity to put into mySQL schema: coffee_order_management_db
 * tables.  
 */
// Will uncomment below annotation lines once basics working & ready to add join
//@Entity
//@Table(name="ORDERS")
public class Order {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="ORDER_ID")
	private int orderID;
	//@Column(name="CUSTOMER_ID")
	private int customerID;
	
	// ??? keep a float or change to a double? 
	// ??? change name to TOTAL??
	//@Column(name="PRICE")
	private float price;
	//@Column(name="ORDER_DATE")
	private LocalDate date;
	
	//@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	//@JoinTable(name="ORDER_DRINK_IDS", joinColumns= @JoinColumn(name="ORDER_ID"), inverseJoinColumns = @JoinColumn(name="DRINK_ID"))
	// ArrayList to hold list of any Drink class objects/entities for each 
	// Order class object/entity
	private ArrayList<Drink> drinkList = new ArrayList<>();

	
	// Constructors
	/**
	 * Default - no args constructor
	 */
	public Order() {
		super();
	}
	
	/**
	 * Non-default constructor - takes only customerID args 
	 * @param customerID
	 */
	public Order(int customerID) {
		super();
		this.customerID = customerID;
	}

	/**
	 * Non-default constructor - may not need since price would be calculated/set
	 * based on ArrayList<Drink> drinklist contents
	 * @param customerID
	 * @param price
	 */
	public Order(int customerID, float price) {
		super();
		this.customerID = customerID;
		this.price = price;
	}

	/**
	 * Non-default constructor - may not need since price would be calculated/set
	 * based on ArrayList<Drink> drinklist contents
	 * @param customerID
	 * @param price
	 * @param drinkList
	 */
	public Order(int customerID, float price, ArrayList<Drink> drinkList) {
		super();
		this.customerID = customerID;
		this.price = price;
		this.drinkList = drinkList;
	}

	/**
	 * Non-default constructor - may not need since price would be calculated/set
	 * based on ArrayList<Drink> drinklist contents & date would be set to date at time
	 * Order object/entity is created
	 * @param customerID
	 * @param price
	 * @param date
	 * @param drinkList
	 */
	public Order(int customerID, float price, LocalDate date, ArrayList<Drink> drinkList) {
		super();
		this.customerID = customerID;
		this.price = price;
		this.date = date;
		this.drinkList = drinkList;
	}

	/**
	 * Non-default constructor - may not need since price would be calculated/set
	 * based on ArrayList<Drink> drinklist contents & date would be set to date at time
	 * Order object/entity is created
	 * @param orderID
	 * @param customerID
	 * @param price
	 * @param date
	 * @param drinkList
	 */
	public Order(int orderID, int customerID, float price, LocalDate date, ArrayList<Drink> drinkList) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.price = price;
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
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
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
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customerID=" + customerID + ", price=" + price + ", date=" + date + "]";
	}


}
