package com.pmc.controller.daoimpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pmc.dao.EmployeeDao;
import com.pmc.entities.DepartmentMaster;
import com.pmc.entities.DesignationMaster;
import com.pmc.entities.EmployeeMaster;

public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory session;

	public boolean saveOrUpdate(EmployeeMaster employeeMaster) {
	 session.getCurrentSession().saveOrUpdate(employeeMaster);
	 return true;
	}

	public List<EmployeeMaster> list() {
		return session.getCurrentSession().createQuery("from EmployeeMaster where activeFlag = '0' ").list(); 
	}
	
	public List<EmployeeMaster> listByDeptId(Long deptId) {
		return session.getCurrentSession().createQuery("from EmployeeMaster where epmDemId="+deptId+" AND activeFlag = '0' ").list(); 
	}

	public List<DepartmentMaster> fetchAllDepartment() {
		 return session.getCurrentSession().createQuery("from DepartmentMaster").list();
	}

	public List<DesignationMaster> fetchAllDesignation() {
		return session.getCurrentSession().createQuery("from DesignationMaster").list();
	}

}
