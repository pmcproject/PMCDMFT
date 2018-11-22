package com.pmc.controller.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmc.dao.UsersDao;
import com.pmc.entities.DepartmentMaster;
import com.pmc.entities.EmployeeMaster;
import com.pmc.entities.RoleMaster;
import com.pmc.entities.Users;
import com.pmc.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	@Qualifier("userDao")
	UsersDao userDao;
	
	public boolean saveOrUpdate(Users users) {
		return userDao.saveOrUpdate(users);
	}

	public List<Users> list() {
		return userDao.list();
	}

	public boolean delete(Users users) {
		return userDao.delete(users);
	}

	public Users findByUserNameAndPassword(String userName, String password) {
		return userDao.findByUserNameAndPassword(userName,password);
	}

	public List<RoleMaster> findAllRole() {
		return userDao.findAllRole();
	}

	public List<DepartmentMaster> fetchAllDepartment() {
		return userDao.fetchAllDepartment();
	}

	public List<EmployeeMaster> loadEmployeeByDepartment(Long departmentId) {
		return userDao.loadEmployeeByDepartment(departmentId);
	}	
	
}
