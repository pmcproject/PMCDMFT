package com.pmc.controller.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmc.dao.InwardDao;
import com.pmc.entities.DepartmentMaster;
import com.pmc.entities.DocumentMaster;
import com.pmc.service.InwardService;

@Service
public class InwardServiceImpl implements InwardService{

	@Autowired
	@Qualifier("inwardDao")
	InwardDao inwardDao;
	
	public List<DocumentMaster> fetchInwardByDepartment(DepartmentMaster domDemId) {
		return inwardDao.fetchInwardByDepartment(domDemId);
	}	
	
}
