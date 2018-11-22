package com.pmc.controller.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmc.dao.FinancialYearDao;
import com.pmc.entities.FinancialYearMaster;
@Repository
@Transactional
public class FinancialYearImpl implements FinancialYearDao{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory session;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean saveOrUpdate(FinancialYearMaster financialYearMaster) {
		session.getCurrentSession().saveOrUpdate(financialYearMaster);
		return true;
	}

	public List<FinancialYearMaster> list() {
		return session.getCurrentSession().createQuery("from FinancialYearMaster").list();
	}

	public boolean delete(FinancialYearMaster financialYearMaster) {
		try{
			session.getCurrentSession().delete(financialYearMaster);
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}


	
	
}
