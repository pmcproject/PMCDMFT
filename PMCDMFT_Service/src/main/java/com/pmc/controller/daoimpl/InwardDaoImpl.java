package com.pmc.controller.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pmc.dao.InwardDao;
import com.pmc.entities.DepartmentMaster;
import com.pmc.entities.DocumentMaster;

@Repository
public class InwardDaoImpl implements InwardDao {
	
    @PersistenceContext
	private EntityManager entityManager;
    
    @Autowired
    @Qualifier("sessionFactory")
	SessionFactory session;

	public List<DocumentMaster> fetchInwardByDepartment(DepartmentMaster department) {
		List<DocumentMaster> lstObject = new ArrayList<DocumentMaster>();
		try {
			Query query =  entityManager.createNamedQuery("fetchInwardByDepartment").setParameter("demId", department.getDemId());
			lstObject = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lstObject;
	}

}