package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListCustomer;
//import model.Customer;

public class ListCustomerHelper{
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoffeeShop");
	//static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoffeeOrders");
	
	public void cleanUp(){
		emfactory.close();
	}
	
	//public void deleteCustomer(Customer toDelete) {
	public void deleteCustomer(ListCustomer toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCustomer> typedQuery = em.createQuery("select li from ListCustomer li where li.firstName = :selectedFirstName and li.lastName = :selectedLastName and li.phoneNumber = :selectedPhoneNumber", ListCustomer.class);
		//TypedQuery<Customer> typedQuery = em.createQuery("select li from Customer li where li.firstName = :selectedFirstName and li.lastName = :selectedLastName and li.phoneNumber = :selectedPhoneNumber", Customer.class);
		//typedQuery.setParameter("selectedFName", toDelete.getFName());
		//typedQuery.setParameter("selectedLName", toDelete.getLName());
		typedQuery.setParameter("selectedFirstName", toDelete.getFirstName());
		typedQuery.setParameter("selectedLastName", toDelete.getLastName());
		typedQuery.setParameter("selectedPhoneNumber", toDelete.getPhoneNumber());
		typedQuery.setMaxResults(1);
		ListCustomer result = typedQuery.getSingleResult();
		//Customer result = typedQuery.getSingleResult();
		em.remove(result);
		
		em.getTransaction().commit();
		em.close();
		
	}
	

	//public void insertCustomer(Customer li){
	public void insertCustomer(ListCustomer li){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	//Search for customer by FirstName
	//public List<Customer> searchForCustomerByFirstName(String customerFirstName) {
	public List<ListCustomer> searchForCustomerByFirstName(String customerFirstName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCustomer> typedQuery = em.createQuery("select li from ListCustomer li where li.firstname = :selectedFirstName", ListCustomer.class);
		//TypedQuery<Customer> typedQuery = em.createQuery("select li from Customer li where li.firstName = :selectedFirstName", Customer.class);
		typedQuery.setParameter("selectedCustomer", customerFirstName);

		List<ListCustomer> foundCustomer = typedQuery.getResultList();
		//List<Customer> foundCustomer = typedQuery.getResultList();
		em.close();
		return foundCustomer;
	}
	
	//Search for customer by LastName
	//public List<Customer> searchForCustomerByLastName(String customerLastName) {
	public List<ListCustomer> searchForCustomerByLastName(String customerLastName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCustomer> typedQuery = em.createQuery("select li from ListCustomer li where li.Lastname = :selectedLastName", ListCustomer.class);
		//TypedQuery<Customer> typedQuery = em.createQuery("select li from ListCustomer li where li.lastName = :selectedLastName", Customer.class);
		typedQuery.setParameter("selectedCustomer", customerLastName);

		List<ListCustomer> foundCustomer = typedQuery.getResultList();
		//List<Customer> foundCustomer = typedQuery.getResultList();
		em.close();
		return foundCustomer;
	}
	
	//Search for customer by Phone Number
	//public List<Customer> searchForCustomerByPhoneNumber(String customerPhoneNumber) {
	public List<ListCustomer> searchForCustomerByPhoneNumber(String customerPhoneNumber) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCustomer> typedQuery = em.createQuery("select li from ListCustomer li where li.phoneNumber = :selectedPhoneNumber", ListCustomer.class);
		//TypedQuery<Customer> typedQuery = em.createQuery("select li from Customer li where li.phoneNumber = :selectedPhoneNumber", Customer.class);
		typedQuery.setParameter("selectedCustomer", customerPhoneNumber);

		List<ListCustomer> foundCustomer = typedQuery.getResultList();
		//List<Customer> foundCustomer = typedQuery.getResultList();
		em.close();
		return foundCustomer;
		
	}

	//Search for customer by ID
	//public Customer searchForCustomerById(int id){
	public ListCustomer searchForCustomerById(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListCustomer found = em.find(ListCustomer.class, id);
		//Customer found = em.find(Customer.class, id);
		em.close();
		return found;
	}

	//Show all customers
	//public List<Customer> showAllCustomers(){
	public List<ListCustomer> showAllCustomers(){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<ListCustomer> typedQuery = em.createQuery("select li from ListCustomer li", ListCustomer.class);
		List<ListCustomer> allCustomers = typedQuery.getResultList();
		//TypedQuery<Customer> typedQuery = em.createQuery("select li from Customer li", Customer.class);
		//List<Customer> allCustomers = typedQuery.getResultList();
		em.close();
		return allCustomers;
	}


	//Update Customer
	//public void updateCustomer(Customer toEdit) {
	public void updateCustomer(ListCustomer toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
