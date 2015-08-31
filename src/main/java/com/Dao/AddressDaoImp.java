package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hand.model.Address;

public class AddressDaoImp implements AddressDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void getAd(Short a) {
		// TODO Auto-generated method stub
		
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "FROM Address WHERE address_id="+a;
		try {
			
			Query query = session.createQuery(sql);
			System.out.println(session);
			Address AD =(Address)query.list().get(0);
			tx.commit();
			System.out.println(AD.getAddress());
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		session.close();
	}

}
