package model;

import java.util.ArrayList;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;

//@Entity
//@Table(name="Customers")
public class ListCustomer {
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="ID")
	private int id;
	//@Column(name="firstName")
	private String firstName;
	//@Column(name="lastName")
	private String lastName;
	//@Column(name="phoneNumber")
	private String phoneNumber;
	
	//Trial of adding this below to help w/ joins
	//@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	//@OneToMany(cascade=CascadeType.MERGE, targetEntity=model.Order.class, fetch=FetchType.EAGER)
	//@OneToMany(cascade=CascadeType.MERGE, targetEntity=model.Order.class, fetch=FetchType.EAGER, orphanRemoval=true)
	//private ArrayList<Order> orders = new ArrayList<>();
	private ArrayList<Order> ordersList = new ArrayList<>();

	
	public ListCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListCustomer(String firstName, String lastName, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String returnCustomerDetails( ) {
		return firstName + " " + lastName + " "+ phoneNumber;
	}

}
