package com.pmc.service;

import java.util.List;

import com.pmc.entities.WardMaster;

public interface WardService {
	public boolean saveOrUpdate(WardMaster wardMaster);
	public List<WardMaster> list();
	public boolean delete(WardMaster wardMaster);
}
