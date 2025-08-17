package Dao;

import java.util.List;

import Dto.Bank_account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BankDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void save_account(Bank_account bank_account) 
	{
		
		entityTransaction.begin();
		entityManager.persist(bank_account);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		entityTransaction.commit();
	}
	
	public List<Bank_account> fetchAll() 
	{
		List<Bank_account> list = (List<Bank_account>) entityManager.createQuery("select x from Bank_account x ").getResultList();
		return list;
	}
	
	public Bank_account fecth_account_details(long acc_no) 
	{
		Bank_account bank_account = entityManager.find(Bank_account.class, acc_no);
		return bank_account;
		
	}
	
	public void update_the_details(Bank_account bank_account) 
	{
		entityTransaction.begin();
		entityManager.merge(bank_account);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		entityTransaction.commit();
	}
	
	public Bank_account find(long acno) 
	{
		Bank_account bank_account = entityManager.find(Bank_account.class, acno);
		return bank_account;
		
	}




}
