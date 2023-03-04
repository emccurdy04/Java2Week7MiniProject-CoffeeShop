/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Mar 2, 2023
* Mini-Project - with Kassidi Freel 
*/
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Drink;
import model.Order;
//import model.Customer;
import model.ListCustomer;

/**
 * DrinkHelper class DAO Data Access Object - does all the
 * persistence interaction with the database (DB)
 */
public class DrinkHelper {
	
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoffeeShop");
	
	/**
	 * Method to create a new Drink object/entity & add to Drinks table
	 */
	public void createNewDrink(Drink drinkToAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(drinkToAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Query Drinks table & get list of all Drinks in the table
	 * @return allDrinks - List<Drink>
	 */
	public List<Drink> showAllDrinks() {
		EntityManager em = emfactory.createEntityManager();
		List<Drink> allDrinks = em.createQuery("SELECT drink FROM Drinks drink").getResultList();
		return allDrinks;
	}

	
	public void deleteDrink(Drink drinkToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Drink> typedQuery = em.createQuery("SELECT drink FROM Drinks drink WHERE drink.drinkID = :selectedDrinkID", Drink.class);
		typedQuery.setParameter("selectedDrinkID", drinkToDelete.getDrinkID());
		typedQuery.setMaxResults(1);
		
		Drink result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	

	public void updateDrink(Drink drinkToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(drinkToEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public Drink searchForDrinkById(int drinkIdToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Drink found = em.find(Drink.class, drinkIdToEdit);
		em.close();
		return found;
	}	
	
	//?? may not need this method?? or change to search by orderID
	public List<Drink> searchForDrinksByID(int drinkID) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Drink> typedQuery = em.createQuery("SELECT drink FROM Drinks drink WHERE drink.drinkID =: selectedDrinkID", Drink.class);
		typedQuery.setParameter("selectedDrinkID", drinkID);
		List<Drink> foundDrinks = typedQuery.getResultList();
		em.close();
		return foundDrinks;
	}
	
	//?? changed about method to this it seemed to make more sense to
	//??? search Drink table by orderID than drinkID above
	// Trying to make way to search for all drinks w/ a specific orderID
	// in the Drinks table & put into a list for display
	// ??? to do this might need to put a orderID attribute in Drink class??
	// ??? or does doing the OneToMany relationship table join take care of this???
	/**
	 * Query Drinks table & get list of all Drinks in the table found for the
	 * specified Order 
	 * @param orderID - int
	 * @return foundDrinks - List<Drink>
	 */
	public List<Drink> searchForDrinksByOrderID(int orderID) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Drink> typedQuery = em.createQuery("SELECT drink FROM Drinks drink WHERE drink.orderID =: selectedOrderID", Drink.class);
		typedQuery.setParameter("selectedOrderID", orderID);
		List<Drink> foundDrinks = typedQuery.getResultList();
		em.close();
		return foundDrinks;
	}

	// ???Not sure if this is redundant method since also similar one in OrderHelper
	// ???that might do the same thing???
	public void addDrinkToList(Drink drinkToAdd, Order orderToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		orderToEdit.addDrinkToList(drinkToAdd);
		em.merge(orderToEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
