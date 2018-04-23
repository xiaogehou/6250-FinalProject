package com.webtools.finalProject.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.webtools.finalProject.pojo.Customer;
import com.webtools.finalProject.pojo.User;


@Repository
public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(String userEmail, String password) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from User WHERE email = :useremail and password = :password");
			q.setString("useremail", userEmail);
			q.setString("password", password);			
			User user = (User) q.uniqueResult();
			return user;
			
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + userEmail, e);
		}
	}
	
	public User getUser(int id) throws Exception{
		try {
			begin();
			Query q = getSession().createQuery("from User WHERE id= :id");
			q.setInteger("id", id);
			User u = (User) q.uniqueResult();
			commit();
			return u;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while get user: " + e.getMessage());
		}
	}
	
//	public User get(String userEmail){
//		try {
//			begin();
//			Query q = getSession().createQuery("from User where userEmail = :useremail");
//			q.setString("useremail", userEmail);
//			User user = (User) q.uniqueResult();
//			return user;
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}
//			return null;
//		
//	}
	

	public User register(User u) throws Exception {
		try {
			begin();
			getSession().save(u);
			commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	
	public void updateUser(User u) throws Exception {
		try {
			begin();
			getSession().merge(u);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while updating user: " + e.getMessage());
		}
	}
	
	public Customer register(Customer c) throws Exception {
		try {
			begin();
			getSession().save(c);
			commit();
			return c;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating customer: " + e.getMessage());
		}
	}
	
	public Customer getCustomer(int id) throws Exception{
		try {
			begin();
			Query q = getSession().createQuery("from Customer WHERE id= :id");
			q.setInteger("id", id);
			Customer c = (Customer) q.uniqueResult();
			commit();
			return c;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while get customer: " + e.getMessage());
		}
	}
	
	public void updateCustomer(Customer c) throws Exception {
		try {
			begin();
			getSession().merge(c);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while updating customer: " + e.getMessage());
		}
	}

}