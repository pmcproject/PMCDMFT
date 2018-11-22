package com.pmc.controller.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmc.dao.WardDao;
import com.pmc.entities.WardMaster;
@Repository
@Transactional
public class WardImpl implements WardDao{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory session;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean saveOrUpdate(WardMaster wardMaster) {
		session.getCurrentSession().saveOrUpdate(wardMaster);
		return true;
	}

	public List<WardMaster> list() {
		return session.getCurrentSession().createQuery("from WardMaster").list();
	}

	public boolean delete(WardMaster wardMaster) {
		try{
			session.getCurrentSession().delete(wardMaster);
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}


	
	
}
