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
//import model.ListCustomer;

/**
 * OrderHelper class DAO Data Access Object - does all the
 * persistence to the database (DB)
 */
public class OrderHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoffeeShop");

	
	public void createNewOrder(Order orderToAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(orderToAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Order> showAllOrders() {
		EntityManager em = emfactory.createEntityManager();
		//List<Order> allOrders = em.createQuery("SELECT order FROM Orders order").getResultList();
		List<Order> allOrders = em.createQuery("SELECT o FROM Orders o").getResultList();
		return allOrders;
	}
	
	
	public void deleteOrder(Order orderToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		//TypedQuery<Order> typedQuery = em.createQuery("SELECT order FROM Orders order WHERE order.orderID = :selectedOrderID", Order.class);
		//TypedQuery<Order> typedQuery = em.createQuery("SELECT o FROM Orders o WHERE order.orderID = :selectedOrderID", Order.class);
		TypedQuery<Order> typedQuery = em.createQuery("SELECT o FROM Orders o WHERE o.orderID = :selectedOrderID", Order.class);
		typedQuery.setParameter("selectedOrderID", orderToDelete.getOrderID());
		typedQuery.setMaxResults(1);
		
		Order result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	

	public void updateOrder(Order orderToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(orderToEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public Order searchForOrderById(int orderIdToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Order found = em.find(Order.class, orderIdToEdit);
		em.close();
		return found;
	}	
	
	//?? may not need this method??
	public List<Order> searchForOrderByID(int orderID) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		//TypedQuery<Order> typedQuery = em.createQuery("SELECT order FROM Orders order WHERE order.orderID =: selectedOrderID", Order.class);
		TypedQuery<Order> typedQuery = em.createQuery("SELECT order FROM Orders order WHERE o.orderID =: selectedOrderID", Order.class);
		typedQuery.setParameter("selectedOrderID", orderID);
		List<Order> foundOrders = typedQuery.getResultList();
		em.close();
		return foundOrders;
	}


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
