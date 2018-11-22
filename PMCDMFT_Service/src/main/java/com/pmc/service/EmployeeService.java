package com.pmc.service;

import java.util.List;

import com.pmc.entities.DepartmentMaster;
import com.pmc.entities.DesignationMaster;
import com.pmc.entities.EmployeeMaster;

public interface EmployeeService {
	public boolean saveOrUpdate(EmployeeMaster employeeMaster);
	public List<EmployeeMaster> list();
	public List<DepartmentMaster> fetchAllDepartment();
	public List<DesignationMaster> fetchAllDesignation();
	public List<EmployeeMaster> listByDeptId(Long deptId);

}
