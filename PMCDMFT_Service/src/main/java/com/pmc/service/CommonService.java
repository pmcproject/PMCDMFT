package com.pmc.service;

import java.util.Date;
import java.util.List;

import com.pmc.entities.DepartmentMaster;
import com.pmc.entities.DocCategoryMaster;
import com.pmc.entities.FinancialYearMaster;
import com.pmc.entities.RoleMaster;
import com.pmc.entities.RoleMenu;
import com.pmc.entities.SystemConfiguration;


public interface CommonService<T> {

	public List<DepartmentMaster> fetchAllDepartment();
	
	public T findById(Class<T> className, Long id);

	public RoleMaster findRoleById(Long roleId);

	public List<RoleMenu> findMenuListByRole(Long romId);
	
	public List<Object> findAll(Class<T> className);

	public Boolean saveOrUpdate(T object);

	public Boolean delete(T object);

	public List<DocCategoryMaster> findCategoryByType(String string);

	public List<SystemConfiguration> findByConfigType(String string);

	public List<Object> fetchByNamedQuery(String query,String parameter);

	public Object fetchObjectByNamedQuery(String query,String parameter);

	public Boolean merge(Object object);

	public List<FinancialYearMaster> fetchAllFinancialYear();

	public Long findAttachmentCount(Long domId);

	public List fetchAllInwardReport(Date fromDate, Date toDate, Long usmId);
	public List fetchAllInwardReportAdmin(Date fromDate, Date toDate);
	
	public List fetchAllOutwardReport(Date fromDate, Date toDate, Long usmId);
	public List fetchAllOutwardReportAdmin(Date fromDate, Date toDate);
	public List fetchAllComplitedReport(Date fromDate, Date toDate, Long usmId);
	public List fetchAllComplitedReportAdmin(Date fromDate, Date toDate);
	
	public List fetchAllRejectedReport(Date fromDate, Date toDate, Long usmId);
	public List fetchAllArchiveListReport(Date fromDate, Date toDate, Long usmId);
	public List fetchInwardAgainstOutwardReport(Date fromDate, Date toDate, Long usmId);
	public List fetchOutwardAgainstInwardReport(Date fromDate, Date toDate, Long usmId);

	public FinancialYearMaster fetchCurrentFinancialYear();
	
	public List fetchpendingletterandfilescount(Long demId,Long query);
	public List fetchpendingletterandfilescountbyuser(Long usmId,Long query);
	public List fetchpendingletterandfilescountbyAdmin();
	public List fetchdocumentcategoryswisebyadmin(Long id,Long query);
	public List fetchFilecategoryswisebyadmin(Long id);

	public String getEncryptedPassword(String password);

	public String getDecryptedPassword(String password);

	public List fetchSearchEngineData(Date fromDate, Date toDate, String cat,
			String inout, Long deptid, Long ftype);
	public List fetchSearchEngineDatabyDepartment(Date fromDate, Date toDate, String cat, String inout, Long deptid, Long ftype, String otherthandept);
	public List fetchAdvanceSearchEngineData(Date fromDate, Date toDate, String cat, String inout, Long deptid, Long ftype,Long fileOrLetterCatetogy,String Otherthandept);
	public List fetchAdvanceSearchEngineDataAdmin(Date fromDate, Date toDate, String cat, String inout, Long deptid, Long ftype,Long fileOrLetterCatetogy,String Otherthandept,String subject);

	public List fetchAdvanceSearchEngineDatabyDepartment(Date fromDate,Date toDate, String cat, String inout, Long deptid, Long ftype,Long fileOrLetterCatetogy, String otherthandept, String subject);
	
	public void updateFinancialNo();
	
	public Boolean CheckAlreadyExist(String tblName,String colmnName,String searchStr);
	
	public List fetchOutwardRegister(Long demId);

	public List fetchOutbox(Long usmId);

	public List loadAllPayrollEmployeeData();
	
}
