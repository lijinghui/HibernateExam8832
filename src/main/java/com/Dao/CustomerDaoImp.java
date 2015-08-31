package com.Dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hand.HibernateExam8832.MyInterceptor;
import com.hand.model.Customer;

public class CustomerDaoImp implements CustomerDao {
	
	private SessionFactory sessionFactory;
	MyInterceptor interceptor = new MyInterceptor();

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveCus(Customer cus) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(cus);
		tx.commit();
		session.close();
	}

	public Customer getCus() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.withOptions().interceptor(interceptor).openSession();
		Transaction tx = session.beginTransaction();
		
		
		return null;
	}

	public void delCus(Customer customer) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(customer);
		tx.commit();
		session.close();
	}

	

}
