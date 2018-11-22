package com.pmc.service;

import java.util.List;

import com.pmc.entities.FinancialYearMaster;

public interface FinancialYearService {
	public boolean saveOrUpdate(FinancialYearMaster financialYearMaster);
	public List<FinancialYearMaster> list();
	public boolean delete(FinancialYearMaster financialYearMaster);
}
