package com.pmc.controller.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmc.dao.DesignationDao;
import com.pmc.entities.DesignationMaster;
import com.pmc.service.DesignationService;
@Repository
@Transactional

public class DesignationServiceImpl implements DesignationService {
	@Autowired
	@Qualifier("designationDao")
	DesignationDao desgDao;

	public boolean saveOrUpdate(DesignationMaster Desg) {
		return desgDao.saveOrUpdate(Desg);
	}

	public List<DesignationMaster> list() {
		return  desgDao.list();
	}
	
	public boolean delete(DesignationMaster Desg) {
		return desgDao.delete(Desg);
	}

	
	}
