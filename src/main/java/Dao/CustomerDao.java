package Dao;

import java.util.List;
import Dto.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.persist(customer);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		entityTransaction.commit();
		
	}
	
	public List<Customer> check1(String email) 
	{
		List<Customer> list=entityManager.createQuery("select x from Customer x where email=?1").setParameter(1, email).getResultList();		
		return list;
	}
	
	public List<Customer> check2(Long ph)
	{
		List<Customer> list=entityManager.createQuery("select x from Customer x where ph=?1").setParameter(1, ph).getResultList();		
		return list;
	}
	
	public Customer login(int customerid)
	{
		Customer customer = entityManager.find(Customer.class, customerid);
		return customer;
	}

	public void update(Customer customer) {
		entityTransaction.begin();
		entityManager.merge(customer);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		entityTransaction.commit();
		
	}


	

}
