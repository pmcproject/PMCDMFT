package com.pmc.controller.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmc.dao.WardDao;
import com.pmc.entities.WardMaster;
import com.pmc.service.WardService;

@Service
public class WardServiceImpl implements WardService{

	@Autowired
	@Qualifier("wardDao")
	WardDao wardDao;
	
	public boolean saveOrUpdate(WardMaster wardMaster) {
		return wardDao.saveOrUpdate(wardMaster);
	}

	public List<WardMaster> list() {
		return wardDao.list();
	}

	public boolean delete(WardMaster wardMaster) {
		return wardDao.delete(wardMaster);
	}

	
	
}
