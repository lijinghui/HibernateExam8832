package com.Dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hand.HibernateExam8832.MyInterceptor;
import com.hand.model.Address;
import com.hand.model.Customer;

public class CustomerDaoImp implements CustomerDao {

	private SessionFactory sessionFactory;
	MyInterceptor interceptor = new MyInterceptor();

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public int saveCus(Customer cus) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.withOptions().interceptor(interceptor).openSession();
		Transaction tx = session.beginTransaction();
		int i = 0 ;
		try {
			short s = (Short) session.save(cus);
			i = s;
			tx.commit();
			return i;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
			
		}
		
		return i;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Customer getCus(int id) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.withOptions().interceptor(interceptor).openSession();
		Transaction tx = session.beginTransaction();
		String sql = "FROM Customer WHERE customerId=" + id;
		try {

			Query query = session.createQuery(sql);
			Customer CU = (Customer) query.list().get(0);
			tx.commit();
			return CU;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}finally {
			
			session.close();
		}
		return null;
	}

	public void delCus(Short id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "delete from Payment where customer_id="+id;
		String oql = "delete from Rental where customer_id="+id;
		String hql = "DELETE FROM Customer WHERE customerId=" + id;
		try {
			
			session.createQuery(sql).executeUpdate();
			session.createQuery(oql).executeUpdate();
			session.createQuery(hql).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}finally {
			
			session.close();
		}
	}

}
