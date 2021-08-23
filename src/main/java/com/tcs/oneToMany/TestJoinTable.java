package com.tcs.oneToMany;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.tcs.oneToMany.joinTable.AccountEntity;
import com.tcs.oneToMany.joinTable.EmployeeEntity;

public class TestJoinTable
{
	
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		AccountEntity account1 = new AccountEntity();
		account1.setAccountNumber("123-345-65554");
		
		AccountEntity account2 = new AccountEntity();
		account2.setAccountNumber("123-345-6552222");
		
		//Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("demo1-user1@mail.com");
		emp.setFirstName("demo1");
		emp.setLastName("user1");
		
		Set<AccountEntity> accounts = new HashSet<AccountEntity>();
		accounts.add(account1);
		accounts.add(account2);
		
		emp.setAccounts(accounts);
		//Save Employee
		session.save(emp);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}