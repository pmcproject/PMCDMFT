package com.pmc.service;

import java.util.List;

import com.pmc.entities.DepartmentMaster;
import com.pmc.entities.DocumentMaster;

public interface InwardService {

	public List<DocumentMaster> fetchInwardByDepartment(DepartmentMaster domDemId);
}
