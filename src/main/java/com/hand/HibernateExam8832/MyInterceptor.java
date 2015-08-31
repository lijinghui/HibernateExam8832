package com.hand.HibernateExam8832;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.hand.model.Customer;

public class MyInterceptor extends EmptyInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// This method is called when Employee object gets created.
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		if (entity instanceof Customer) {
			System.out.println("Before save");
			return true;
		}
		return false;
	}


}
