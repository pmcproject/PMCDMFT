package com.pmc.controller.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pmc.dao.UsersDao;
import com.pmc.entities.DepartmentMaster;
import com.pmc.entities.EmployeeMaster;
import com.pmc.entities.RoleMaster;
import com.pmc.entities.Users;
@Repository
@Transactional
public class UsersImpl implements UsersDao{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory session;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean saveOrUpdate(Users users) {
		session.getCurrentSession().saveOrUpdate(users);
		return true;
	}

	public List<Users> list() {
		return session.getCurrentSession().createQuery("from Users").list();
	}

	public boolean delete(Users users) {
		try{
			session.getCurrentSession().delete(users);
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public Users findByUserNameAndPassword(String userName, String password) {
		
		Users users =null; 
		try {
			Criteria criteria = session.getCurrentSession().createCriteria(Users.class);
			criteria.add(Restrictions.eq("usmUserName", userName));
			criteria.add(Restrictions.eq("usmUserPass", password));
			
			List<Users> lstUser = criteria.list();
			if(lstUser!=null && lstUser.size()>0) {
				users = (Users) lstUser.get(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public List<RoleMaster> findAllRole() {
		return session.getCurrentSession().createQuery("from RoleMaster").list();
	}
	
	public List<DepartmentMaster> fetchAllDepartment() {
		return session.getCurrentSession().createQuery("from DepartmentMaster").list();
	}

	public List<EmployeeMaster> loadEmployeeByDepartment(Long departmentId) {
		return session.getCurrentSession().createQuery("from EmployeeMaster where epmDemId.demId ="+departmentId+" ").list();
	}
	
	
}
