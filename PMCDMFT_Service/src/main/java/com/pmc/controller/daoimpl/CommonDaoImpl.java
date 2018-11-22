package com.pmc.controller.daoimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pmc.dao.CommonDao;
import com.pmc.entities.DepartmentMaster;
import com.pmc.entities.DocCategoryMaster;
import com.pmc.entities.FinancialYearMaster;
import com.pmc.entities.RoleMaster;
import com.pmc.entities.RoleMenu;
import com.pmc.entities.SystemConfiguration;

@Repository
public class CommonDaoImpl<T> implements CommonDao<T> {
	
    @PersistenceContext
	private EntityManager entityManager;
    
    @Autowired
    @Qualifier("sessionFactory")
	SessionFactory session;

	public List<DepartmentMaster> fetchAllDepartment() {
		List<DepartmentMaster> lstObject = new ArrayList<DepartmentMaster>();
		
		try {
			Query query =  entityManager.createNamedQuery("getAllDepartment");
			lstObject = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstObject;
	}

	public T findById(Class<T> className,Long id) {
		return entityManager.find(className, id);
	}

	public List<Object> findAll(Class<T> className) {
		List<Object> lstData =  entityManager.createQuery("Select t from " + className.getSimpleName() + " t").getResultList();
		return lstData;
	}
	
	public RoleMaster findRoleById(Long roleId) {
		return entityManager.find(RoleMaster.class, roleId);
	}

	public List<RoleMenu> findMenuListByRole(Long romId) {
		List<RoleMenu> lstObject = new ArrayList<RoleMenu>();
		try {
			Query query =  entityManager.createNamedQuery("fetchMenuListByRole").setParameter("romId", romId);
			lstObject = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lstObject;
	}

	public Boolean saveOrUpdate(T object) {
		try {
			session.getCurrentSession().saveOrUpdate(object);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean merge(Object object) {
		try {
			session.getCurrentSession().merge(object);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean delete(T object) {
		try {
			session.getCurrentSession().delete(object);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<DocCategoryMaster> findCategoryByType(String type) {
		List<DocCategoryMaster> lstObject = new ArrayList<DocCategoryMaster>();
		try {
			Query query =  entityManager.createNamedQuery("fetchCategoryByType").setParameter("dcmCategoryType", type);
			lstObject = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lstObject;
	}
	
	public List<SystemConfiguration> findByConfigType(String configType) {
		List<SystemConfiguration> lstObject = new ArrayList<SystemConfiguration>();
		try {
			Query query =  entityManager.createNamedQuery("fetchConfigByConfigType").setParameter("configType", configType);
			lstObject = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lstObject;
	}

	public List<Object> fetchByNamedQuery(String namedQuery,String parameter) {
		List<Object> lstObject = new ArrayList<Object>();
		try {
			Query query =  entityManager.createNamedQuery(namedQuery);
			
			if (parameter != null && !parameter.equals("")) {
				String[] indExpres = parameter.split("&");

				for (int i = 0; i < indExpres.length; i++) {
					String[] indParam = indExpres[i].split("=");
					
					if (indParam[2].toLowerCase().equals("string")) 
						query = query.setParameter(indParam[0], indParam[1]);
					else if (indParam[2].toLowerCase().equals("long")) 
						query = query.setParameter(indParam[0],	Long.parseLong(indParam[1]));
					else if (indParam[2].toLowerCase().equals("double")) 
						query = query.setParameter(indParam[0], Double.parseDouble(indParam[1]));
					else if (indParam[2].toLowerCase().equals("float")) 
						query = query.setParameter(indParam[0], Float.parseFloat(indParam[1]));
					else if (indParam[2].toLowerCase().equals("character")) 
						query = query.setParameter(indParam[0], (indParam[1]).charAt(0));
					else if (indParam[2].toLowerCase().equals("int") || indParam[2].toLowerCase().equals("integer")) 
						query = query.setParameter(indParam[0], Integer.parseInt((indParam[1])));
				}
			}
			query.setMaxResults(1000);
			
			lstObject = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lstObject;
	}
	
	public Object fetchObjectByNamedQuery(String namedQuery,String parameter) {
		Object object = null ; 
		try {
			Query query =  entityManager.createNamedQuery(namedQuery);
			if (parameter != null && !parameter.equals("")) {
				String[] indExpres = parameter.split("&");

				for (int i = 0; i < indExpres.length; i++) {
					String[] indParam = indExpres[i].split("=");
					
					if (indParam[2].toLowerCase().equals("string")) 
						query = query.setParameter(indParam[0], indParam[1]);
					else if (indParam[2].toLowerCase().equals("long")) 
						query = query.setParameter(indParam[0],	Long.parseLong(indParam[1]));
					else if (indParam[2].toLowerCase().equals("double")) 
						query = query.setParameter(indParam[0], Double.parseDouble(indParam[1]));
					else if (indParam[2].toLowerCase().equals("float")) 
						query = query.setParameter(indParam[0], Float.parseFloat(indParam[1]));
					else if (indParam[2].toLowerCase().equals("character")) 
						query = query.setParameter(indParam[0], (indParam[1]).charAt(0));
					else if (indParam[2].toLowerCase().equals("int") || indParam[2].toLowerCase().equals("integer")) 
						query = query.setParameter(indParam[0], Integer.parseInt((indParam[1])));
				}
			}
			object = query.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public List<FinancialYearMaster> fetchAllFinancialYear() {
		List<FinancialYearMaster> lstObject = new ArrayList<FinancialYearMaster>();
		
		try {
			Query query =  entityManager.createNamedQuery("fetchAllFinancialYear");
			lstObject = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstObject;
	}

	public Long findAttachmentCount(Long domId) {
		Long attachmentCount = 0l;
		try {
			attachmentCount =  (Long) entityManager.createNamedQuery("findAttachmentCount").setParameter("domId", domId).getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return attachmentCount;
	}

	public List fetchAllInwardReport(Date fromDate, Date toDate, Long usmId) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String _fromdate = df.format(fromDate);
		String _Todate = df.format(toDate);
		List obj=new ArrayList();
		try {
			Query q = entityManager.createNativeQuery("select * from fun_rpt_Inward_Register("+usmId+",'"+_fromdate+"','"+_Todate+"')");
			obj = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	public List fetchAllInwardReportAdmin(Date fromDate, Date toDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String _fromdate = df.format(fromDate);
		String _Todate = df.format(toDate);
		List obj=new ArrayList();
		try {
			Query q = entityManager.createNativeQuery("select * from allinwardreportAdmin('"+_fromdate+"','"+_Todate+"')");
			obj = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	public List fetchAllOutwardReport(Date fromDate, Date toDate, Long usmId) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String _fromdate = df.format(fromDate);
		String _Todate = df.format(toDate);
		List obj=new ArrayList();
		try {
			Query q = entityManager.createNativeQuery("select * from fun_rpt_Outward_Register("+usmId+",'"+_fromdate+"','"+_Todate+"')");
			obj = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	public List fetchAllOutwardReportAdmin(Date fromDate, Date toDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String _fromdate = df.format(fromDate);
		String _Todate = df.format(toDate);
		List obj=new ArrayList();
		try {
			
			Query q = entityManager.createNativeQuery("select * from alloutwardreportAdmin('"+_fromdate+"','"+_Todate+"')");
			obj = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public List fetchAllComplitedReport(Date fromDate, Date toDate, Long usmId) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String _fromdate = df.format(fromDate);
		String _Todate = df.format(toDate);
		List obj=new ArrayList();
		try {
			Query q = entityManager.createNativeQuery("select * from fun_rpt_completed_list("+usmId+",'"+_fromdate+"','"+_Todate+"')");
			obj = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	public List fetchAllComplitedReportAdmin(Date fromDate, Date toDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String _fromdate = df.format(fromDate);
		String _Todate = df.format(toDate);
		List obj=new ArrayList();
		try {
			Query q = entityManager.createNativeQuery("select * from allcomplitedreportAdmin('"+_fromdate+"','"+_Todate+"')");
			obj = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public List fetchAllRejectedReport(Date fromDate, Date toDate, Long usmId) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String _fromdate = df.format(fromDate);
		String _Todate = df.format(toDate);
		List obj=new ArrayList();
		try {
			Query q = entityManager.createNativeQuery("select * from fun_rpt_rejected_list("+usmId+",'"+_fromdate+"','"+_Todate+"')");
			obj = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	public List fetchAllArchiveListReport(Date fromDate, Date toDate, Long usmId) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String _fromdate = df.format(fromDate);
		String _Todate = df.format(toDate);
		List obj=new ArrayList();
		try {
			Query q = entityManager.createNativeQuery("select * from fun_rpt_archived_list("+usmId+",'"+_fromdate+"','"+_Todate+"')");
			obj = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	public List fetchInwardAgainstOutwardReport(Date fromDate, Date toDate, Long usmId) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String _fromdate = df.format(fromDate);
		String _Todate = df.format(toDate);
		List obj=new ArrayList();
		try {
			Query q = entityManager.createNativeQuery("select * from fun_rpt_inward_against_outward_register("+usmId+",'"+_fromdate+"','"+_Todate+"')");
			obj = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	public List fetchOutwardAgainstInwardReport(Date fromDate, Date toDate, Long usmId) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String _fromdate = df.format(fromDate);
		String _Todate = df.format(toDate);
		List obj=new ArrayList();
		try {
			Query q = entityManager.createNativeQuery("select * from fun_rpt_outward_against_inward_register("+usmId+",'"+_fromdate+"','"+_Todate+"')");
			obj = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	public FinancialYearMaster fetchCurrentFinancialYear() {
		FinancialYearMaster Object = new  FinancialYearMaster();
		try {
			Query query =  entityManager.createNamedQuery("fetchActiveFinancialYear");
			if(query.getResultList().size() > 0) {
				Object = (FinancialYearMaster) query.getSingleResult();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Object;
	}
	public List fetchpendingletterandfilescount(Long demId,Long query) {
	
		List obj=new ArrayList();
		try {
			Query q = entityManager.createNativeQuery("select * from fun_rpt_pending_letters_files_count("+query+","+demId+")");
			obj = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	public List fetchpendingletterandfilescountbyuser(Long usmId,Long query) {
		
		List obj=new ArrayList();
		try {
			Query q = entityManager.createNativeQuery("select * from fun_rpt_pending_letters_files__user_count("+query+","+usmId+")");
			obj = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
public List fetchpendingletterandfilescountbyAdmin() {
		
		List obj=new ArrayList();
		try {
			Query q = entityManager.createNativeQuery("select * from allpendingletterandfilecountsbyadminNew()");
			obj = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
public List fetchdocumentcategoryswisebyadmin(Long id,Long query) {
	
	List obj=new ArrayList();
	try {
		Query q = entityManager.createNativeQuery("select * from fun_rpt_letter_file_category_count("+query+","+id+")");
		obj = q.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return obj;
}
public List fetchFilecategoryswisebyadmin(Long id) {
	
	List obj=new ArrayList();
	try {
		Query q = entityManager.createNativeQuery("select * from filecategorywisereport("+id+")");
		obj = q.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return obj;
}
public String getEncryptedPassword(String password) {
	Encrypter objencry=new Encrypter();
	String pw="";
	try {
		pw=objencry.setData(password);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return pw;
}
public String getDecryptedPassword(String password) {
	Encrypter objencry=new Encrypter();
	String pw="";
	try {
		pw=objencry.getData(password);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return pw;
}
public List fetchSearchEngineData(Date fromDate, Date toDate,String cat,String inout,Long deptid,Long ftype) {
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String _fromdate = df.format(fromDate);
	String _Todate = df.format(toDate);
	List obj=new ArrayList();
	try {
		Query q = entityManager.createNativeQuery("select * from fun_search_engine('"+_fromdate+"','"+_Todate+"','"+cat+"','"+inout+"',"+deptid+","+ftype+")");
		obj = q.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return obj;
}
public List fetchSearchEngineDatabyDepartment(Date fromDate, Date toDate,String cat,String inout,Long deptid,Long ftype,String otherthandept) {
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String _fromdate = df.format(fromDate);
	String _Todate = df.format(toDate);
	List obj=new ArrayList();
	try {
		Query q = entityManager.createNativeQuery("select * from fun_search_engine_by_department('"+_fromdate+"','"+_Todate+"','"+cat+"','"+inout+"',"+deptid+","+ftype+",'"+otherthandept+"')");
		obj = q.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return obj;
}
public List fetchAdvanceSearchEngineData(Date fromDate, Date toDate,String cat,String inout,Long deptid,Long ftype,Long fileOrLetterCatetogy,String Otherthandept) {
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String _fromdate = df.format(fromDate);
	String _Todate = df.format(toDate);
	List obj=new ArrayList();
	try {
		Query q = entityManager.createNativeQuery("select * from fun_Advance_search_engine('"+_fromdate+"','"+_Todate+"','"+cat+"','"+inout+"',"+deptid+","+ftype+","+fileOrLetterCatetogy+",'"+Otherthandept+"')");
		obj = q.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return obj;
}

public List fetchAdvanceSearchEngineDataAdmin(Date fromDate, Date toDate, String cat, String inout, Long deptid, Long ftype, Long fileOrLetterCatetogy, String otherthandept, String subject) {
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String _fromdate = df.format(fromDate);
	String _Todate = df.format(toDate);
	List obj=new ArrayList();
	try {
		Query q;
		if(subject.equals(""))
		{
			 q = entityManager.createNativeQuery("select * from fun_Advance_search_engine('"+_fromdate+"','"+_Todate+"','"+cat+"','"+inout+"',"+deptid+","+ftype+","+fileOrLetterCatetogy+",'"+otherthandept+"','"+subject+"')");
		}
		else
		{
			 q = entityManager.createNativeQuery("select * from fun_Advance_search_engine('"+_fromdate+"','"+_Todate+"','"+cat+"','"+inout+"',"+deptid+","+ftype+","+fileOrLetterCatetogy+",'"+otherthandept+"','%"+subject+"%')");
		}
		
		obj = q.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return obj;
}

public List fetchAdvanceSearchEngineDatabyDepartment(Date fromDate, Date toDate, String cat, String inout, Long deptid, Long ftype, Long fileOrLetterCatetogy, String otherthandept, String subject) {
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String _fromdate = df.format(fromDate);
	String _Todate = df.format(toDate);
	List obj=new ArrayList();
	try {
		Query q;
		if(subject.equals(""))
		{
			 q = entityManager.createNativeQuery("select * from fun_advance_search_engine_by_department('"+_fromdate+"','"+_Todate+"','"+cat+"','"+inout+"',"+deptid+","+ftype+","+fileOrLetterCatetogy+",'"+otherthandept+"','"+subject+"')");
		}
		else
		{
			 q = entityManager.createNativeQuery("select * from fun_advance_search_engine_by_department('"+_fromdate+"','"+_Todate+"','"+cat+"','"+inout+"',"+deptid+","+ftype+","+fileOrLetterCatetogy+",'"+otherthandept+"','%"+subject+"%')");
		}
		
		obj = q.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return obj;
}
public void updateFinancialNo() {
	
	List obj=new ArrayList();
	try {
		Query q;
		
			 q = entityManager.createNativeQuery("update  tbl_financial_year_master  set activeflag='N' where activeflag='Y'");
			
		obj = q.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
public Boolean CheckAlreadyExist(String tblName, String colmnName,String searchStr) {
	
	List obj=new ArrayList();
	try {
		Query q;
		
		 q = entityManager.createNativeQuery("select * from fun_check_duplicate('"+tblName+"','"+colmnName+"','"+searchStr+"')");
			
		obj = q.getResultList();
	if(obj.size() > 0)
	{
		
		return true;
	}
	else
	{
		return false;
	}
		
	} catch (Exception e) {
		
		e.printStackTrace();
		return false;
	}
	
}

public List fetchOutwardRegister(Long deptid) {
	
	List obj=new ArrayList();
	try {
		Query q;
		
			 q = entityManager.createNativeQuery("select * from fun_rpt_outward_register_new("+deptid+")");
		
		obj = q.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return obj;
}
public List fetchOutbox(Long usmId) {
	
	List obj=new ArrayList();
	try {
		Query q;
		
			 q = entityManager.createNativeQuery("select * from fun_rpt_outbox("+usmId+")");
		
		obj = q.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return obj;
}

public List loadAllPayrollEmployeeData() {
	List obj=new ArrayList();
	try {
		Query q = entityManager.createNativeQuery("select * from est_empmaster order by key");
		obj = q.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return obj;
}
}