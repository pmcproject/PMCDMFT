package com.pmc.controller.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmc.dao.FinancialYearDao;
import com.pmc.entities.FinancialYearMaster;
import com.pmc.service.FinancialYearService;

@Service
public class FinancialYearServiceImpl implements FinancialYearService{

	@Autowired
	@Qualifier("financialYearDao")
	FinancialYearDao financialYearDao;
	
	public boolean saveOrUpdate(FinancialYearMaster financialYearMaster) {
		return financialYearDao.saveOrUpdate(financialYearMaster);
	}

	public List<FinancialYearMaster> list() {
		return financialYearDao.list();
	}

	public boolean delete(FinancialYearMaster financialYearMaster) {
		return financialYearDao.delete(financialYearMaster);
	}

	
	
}
