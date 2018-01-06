package com.web.customer.tracker.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.customer.tracker.dao.CustomerDAO;
import com.web.customer.tracker.entity.CustomerEntity;

@Repository
public class CustomerDaoImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CustomerEntity> getAllCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<CustomerEntity> query = 
				session.createQuery("from CustomerEntity order by firstName", CustomerEntity.class);
		return query.getResultList();
	}
	
	@Override
	public void addCustomer(CustomerEntity customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@Override
	public CustomerEntity getCustomerById(int id) {
		return sessionFactory.getCurrentSession().get(CustomerEntity.class, id);
	}

	@Override
	public void deleteCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<?> query = session.createQuery("delete from CustomerEntity where id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();		
	}

}
