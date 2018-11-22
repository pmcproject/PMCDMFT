package com.pmc.service;

import java.util.List;

import com.pmc.entities.DepartmentMaster;
import com.pmc.entities.EmployeeMaster;
import com.pmc.entities.RoleMaster;
import com.pmc.entities.Users;

public interface UsersService {
	public boolean saveOrUpdate(Users users);
	public List<Users> list();
	public boolean delete(Users users);
	public Users findByUserNameAndPassword(String userName,String password);
	public List<RoleMaster> findAllRole();
	public List<DepartmentMaster> fetchAllDepartment();
	public List<EmployeeMaster> loadEmployeeByDepartment(Long departmentId);
}
