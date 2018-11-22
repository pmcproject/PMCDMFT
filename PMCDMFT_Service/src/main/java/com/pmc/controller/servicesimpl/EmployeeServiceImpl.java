package com.pmc.controller.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmc.dao.DesignationDao;
import com.pmc.dao.EmployeeDao;
import com.pmc.entities.EmployeeMaster;
import com.pmc.entities.DepartmentMaster;
import com.pmc.entities.DesignationMaster;
import com.pmc.service.EmployeeService;

@Repository
@Transactional

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	@Qualifier("employeeDao")
	EmployeeDao employeeDao;

	public boolean saveOrUpdate(EmployeeMaster employeeMaster) {
		return employeeDao.saveOrUpdate(employeeMaster);
	}

	public List<EmployeeMaster> list() {
		return employeeDao.list(); 
		}

	public List<DepartmentMaster> fetchAllDepartment() {
		 return employeeDao.fetchAllDepartment();
	}

	public List<DesignationMaster> fetchAllDesignation() {
		 return employeeDao.fetchAllDesignation();
	}

	public List<EmployeeMaster> listByDeptId(Long deptId) {
		return employeeDao.listByDeptId(deptId) ;
	}

}
