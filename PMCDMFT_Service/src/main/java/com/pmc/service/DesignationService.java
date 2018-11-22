package com.pmc.service;

import java.util.List;

import com.pmc.entities.DesignationMaster;
import com.pmc.entities.Users;

public interface DesignationService {
	public boolean saveOrUpdate(DesignationMaster Desg);
	public List<DesignationMaster> list();
	public boolean delete(DesignationMaster desg);
}
