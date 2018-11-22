package com.pmc.controller.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pmc.dao.DesignationDao;
import com.pmc.entities.DesignationMaster;

public class DesignationDaoImpl implements DesignationDao {

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory session;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean saveOrUpdate(DesignationMaster desg) {
		session.getCurrentSession().saveOrUpdate(desg);
		return true;
	}

	public List<DesignationMaster> list() {
		return session.getCurrentSession().createQuery("from DesignationMaster").list();
	}

	public boolean delete(DesignationMaster desg) {
		try{
			session.getCurrentSession().delete(desg);
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

}
