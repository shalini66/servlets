package com.capgemini.empwebapp2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.empwebapp2.dto.EmployeeBean;

public class EmployeeDAOImplements implements EmployeeDAO {
	
	public final static EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");

	@Override
	public boolean register(EmployeeBean bean) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
	    transaction.begin();
	    manager.persist(bean);
	    System.out.println("Record Register ");
	    transaction.commit();
		return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}

	@Override
	public List<EmployeeBean> search(String name) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select e from EmployeeBean e where e.name =:name";
		TypedQuery<EmployeeBean> query = manager.createQuery(jpql,EmployeeBean.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public boolean changePassword(int id, String password) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		bean.setPassword(password);
		transaction.commit();
		return true;
	}

	@Override
	public EmployeeBean auth(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select e from EmployeeBean e where e.email =:email and e.password=:password";
		TypedQuery<EmployeeBean> query = manager.createQuery(jpql,EmployeeBean.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			return query.getSingleResult();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
