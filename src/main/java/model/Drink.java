/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Feb 26, 2023
* Mini-Project - with Kassidi Freel 
*/
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import controller.DrinkHelper;

/**
 * Drink class - blueprint for creating an instance of Drink
 * class object/entity to put into mySQL schema: coffee_order_management_db
 * tables. 
 */
//Will uncomment below annotation lines once basics working & ready to add join
//???may not need to create an entity for this & just use it as a basic class that
//???is used by Order class

@Entity(name="Drinks")
@Table(name="Drinks")
public class Drink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DRINK_ID")
	private int drinkID;
	@Column(name="DRINK_SIZE")
	private String drinkSize;
	@Column(name="DRINK_TYPE")
	private String drinkType;
	@Column(name="DRINK_PRICE")
	private double basePrice;
	
	
	// Constructors
	/**
	 * Default - no args constructor
	 */
	public Drink() {
		super();
	}
	
	

	/**
	 * Non-default constructor - takes all args except drinkID & basePrice 
	 * since will be determined based on drinkSize
	 * @param drinkSize
	 * @param drinkType
	 */
	public Drink(String drinkSize, String drinkType) {
		super();
		this.drinkSize = drinkSize;
		this.drinkType = drinkType;
		setBasePrice(drinkSize);
		this.basePrice = getBasePrice();
		//this.basePrice = setBasePrice(drinkSize);
	}



	/**
	 * Non-default constructor - takes all args except basePrice since will 
	 * be calculated based on drinkSize
	 * @param drinkID
	 * @param drinkSize
	 * @param drinkType
	 */
	public Drink(int drinkID, String drinkSize, String drinkType) {
		super();
		this.drinkID = drinkID;
		this.drinkSize = drinkSize;
		this.drinkType = drinkType;
		setBasePrice(drinkSize);
		this.basePrice = getBasePrice();
	}
	

	/**
	 * Non-default constructor - takes all args except for drinkID - 
	 * may not need this constructor
	 * @param drinkSize
	 * @param drinkType
	 * @param basePrice
	 */
	public Drink(String drinkSize, String drinkType, double basePrice) {
		super();
		this.drinkSize = drinkSize;
		this.drinkType = drinkType;
		this.basePrice = basePrice;
	}


	/**
	 * Non-default constructor - takes all args - may not need this constructor
	 * @param drinkID
	 * @param drinkSize
	 * @param drinkType
	 * @param basePrice
	 */
	public Drink(int drinkID, String drinkSize, String drinkType, double basePrice) {
		super();
		this.drinkID = drinkID;
		this.drinkSize = drinkSize;
		this.drinkType = drinkType;
		this.basePrice = basePrice;
	}

	
	// Getters/Setters
	/**
	 * @return the drinkID
	 */
	public int getDrinkID() {
		return drinkID;
	}


	/**
	 * @param drinkID the drinkID to set
	 */
	public void setDrinkID(int drinkID) {
		this.drinkID = drinkID;
	}	
	
	
	/**
	 * @return the drinkSize
	 */
	public String getDrinkSize() {
		return drinkSize;
	}

	/**
	 * @param drinkSize the drinkSize to set
	 */
	public void setDrinkSize(String drinkSize) {
		this.drinkSize = drinkSize;
	}

	/**
	 * @return the drinkType
	 */
	public String getDrinkType() {
		return drinkType;
	}

	/**
	 * @param drinkType the drinkType to set
	 */
	public void setDrinkType(String drinkType) {
		// ? Either this acts as parent class for child classes of 
		// Expresso, Macchiato, Latte, & Cappuccino to inherit from
		// or create the switch CASE for the 4 drink types - 
		// I liked your idea for the switch CASE - would place
		// here - either that or an if/else if like did in the
		// setBasePrice() method below
		// [1]Expresso, [2]Latte, [3]Macchiato, [4]Cappuccino
		
		// ??? Re-thinking - Might not need either of above if set
		// up webpage to allow user to select one of these 4 text strings
		this.drinkType = drinkType;
	}

	/**
	 * @return the basePrice
	 */
	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * @param basePrice the basePrice to set
	 */
	//public void setBasePrice(double basePrice) {
	public void setBasePrice(String drinkSize) {
		// the drinkSize will be used to set the basePrice amount
		if (drinkSize.equalsIgnoreCase("small")) {
			this.basePrice = 2.99;
		} else if (drinkSize.equalsIgnoreCase("medium")) {
			this.basePrice = 3.99;
		} else if (drinkSize.equalsIgnoreCase("large")) {
			this.basePrice = 4.99;
		}
		//this.basePrice = basePrice;
	}

	// Helper methods
//	@Override
//	public String toString() {
//		return "Drink [drinkSize=" + drinkSize + ", drinkType=" + drinkType + ", basePrice=" + basePrice + "]";
//	}
	
	@Override
	public String toString() {
		return "Drink [drinkID=" + drinkID + ", drinkSize=" + drinkSize + ", drinkType=" + drinkType + ", basePrice="
				+ basePrice + "]";
	}
	
	public String showSingleDrinkDetails(Drink drink) {
		//DrinkHelper dhdao = new DrinkHelper();
		Drink thisDrink = drink;
		//int thisDrinkID = thisDrink.getDrinkID();
		//Drink thisDrink = dhdao.searchForDrinkById(drinkID);
		StringBuilder sb = new StringBuilder();
		sb.append("Drink: ");
		sb.append(thisDrink.toString());
		return sb.toString();
	}
	
	public String displaySingleDrinkDetails(int drinkID) {
		DrinkHelper dhdao = new DrinkHelper();
		Drink thisDrink = dhdao.searchForDrinkById(drinkID);
		StringBuilder sb = new StringBuilder();
		sb.append("Drink: ");
		sb.append(thisDrink.toString());
		return sb.toString();
	}
	
	
}

