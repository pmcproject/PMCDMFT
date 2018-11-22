package com.pmc.controller.servicesimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmc.dao.CommonDao;
import com.pmc.entities.DepartmentMaster;
import com.pmc.entities.DocCategoryMaster;
import com.pmc.entities.FinancialYearMaster;
import com.pmc.entities.RoleMaster;
import com.pmc.entities.RoleMenu;
import com.pmc.entities.SystemConfiguration;
import com.pmc.service.CommonService;

@Service
public class CommonServiceImpl<T> implements CommonService<T>{

	@Autowired
	@Qualifier("commonDao")
	CommonDao<T> commonDao;

	public List<DepartmentMaster> fetchAllDepartment() {
		return commonDao.fetchAllDepartment();
	}

	public T findById(Class<T> className,Long id) {
		return commonDao.findById(className,id);
	}

	public RoleMaster findRoleById(Long roleId) {
		return commonDao.findRoleById(roleId);
	}

	public List<RoleMenu> findMenuListByRole(Long romId) {
		return commonDao.findMenuListByRole(romId);
	}

	public List<Object> findAll(Class<T> className) {
		return commonDao.findAll(className);
	}

	public Boolean saveOrUpdate(T object) {
		return commonDao.saveOrUpdate(object);
	}

	public Boolean delete(T object) {
		return commonDao.delete(object);
	}

	public List<DocCategoryMaster> findCategoryByType(String type) {
		return commonDao.findCategoryByType(type);
	}

	public List<SystemConfiguration> findByConfigType(String configType) {
		return commonDao.findByConfigType(configType);
	}

	public List<Object> fetchByNamedQuery(String query,String parameter) {
		return commonDao.fetchByNamedQuery(query,parameter);
	}

	public Object fetchObjectByNamedQuery(String query, String parameter) {
		return commonDao.fetchObjectByNamedQuery(query,parameter);
	}

	public Boolean merge(Object object) {
		return commonDao.merge(object);
	}

	public List<FinancialYearMaster> fetchAllFinancialYear() {
		return commonDao.fetchAllFinancialYear();
	}

	public Long findAttachmentCount(Long domId) {
		return commonDao.findAttachmentCount(domId);
	}

	public List fetchAllInwardReport(Date fromDate, Date toDate, Long usmId) {
		return commonDao.fetchAllInwardReport(fromDate,toDate,usmId);
	}
	public List fetchAllInwardReportAdmin(Date fromDate, Date toDate) {
		return commonDao.fetchAllInwardReportAdmin(fromDate,toDate);
	}

	public List fetchAllOutwardReport(Date fromDate, Date toDate, Long usmId) {
		return commonDao.fetchAllOutwardReport(fromDate,toDate,usmId);
	
	}
	public List fetchAllOutwardReportAdmin(Date fromDate, Date toDate) {
		return commonDao.fetchAllOutwardReportAdmin(fromDate,toDate);
	
	}
	
	public List fetchAllComplitedReport(Date fromDate, Date toDate, Long usmId) {
		return commonDao.fetchAllComplitedReport(fromDate,toDate,usmId);
	
	}
	public List fetchAllComplitedReportAdmin(Date fromDate, Date toDate) {
		return commonDao.fetchAllComplitedReportAdmin(fromDate,toDate);
	
	}
	
	public List fetchAllRejectedReport(Date fromDate, Date toDate, Long usmId) {
		return commonDao.fetchAllRejectedReport(fromDate,toDate,usmId);
	
	}
	public List fetchAllArchiveListReport(Date fromDate, Date toDate, Long usmId) {
		return commonDao.fetchAllArchiveListReport(fromDate,toDate,usmId);
	
	}
	public List fetchInwardAgainstOutwardReport(Date fromDate, Date toDate, Long usmId) {
		return commonDao.fetchInwardAgainstOutwardReport(fromDate,toDate,usmId);
	}
	public List fetchOutwardAgainstInwardReport(Date fromDate, Date toDate, Long usmId) {
		return commonDao.fetchOutwardAgainstInwardReport(fromDate,toDate,usmId);
	}

	public FinancialYearMaster fetchCurrentFinancialYear() {
		return commonDao.fetchCurrentFinancialYear();
	}
	public List fetchpendingletterandfilescount(Long demId,Long query) {
		return commonDao.fetchpendingletterandfilescount(demId,query);
	}
	public List fetchpendingletterandfilescountbyuser(Long usmId,Long query) {
		return commonDao.fetchpendingletterandfilescountbyuser(usmId,query);
	}
	public List fetchpendingletterandfilescountbyAdmin() {
		return commonDao.fetchpendingletterandfilescountbyAdmin();
	}
	public List fetchdocumentcategoryswisebyadmin(Long id,Long query) {
		return commonDao.fetchdocumentcategoryswisebyadmin(id,query);
	}
	public List fetchFilecategoryswisebyadmin(Long id) {
		return commonDao.fetchFilecategoryswisebyadmin(id);
	}

	public String getEncryptedPassword(String password) {
		return commonDao.getEncryptedPassword(password);
	}
	public String getDecryptedPassword(String password) {
		return commonDao.getDecryptedPassword(password);
	}
	
	public List fetchSearchEngineData(Date fromDate, Date toDate,String cat,String inout,Long deptid,Long ftype) {
		return commonDao.fetchSearchEngineData(fromDate,toDate,cat,inout,deptid,ftype);
	
	}
	public List fetchAdvanceSearchEngineData(Date fromDate, Date toDate,String cat,String inout,Long deptid,Long ftype,Long fileOrLetterCatetogy,String Otherthandept) {
		return commonDao.fetchAdvanceSearchEngineData(fromDate,toDate,cat,inout,deptid,ftype,fileOrLetterCatetogy,Otherthandept);
	
	}
	public List fetchAdvanceSearchEngineDataAdmin(Date fromDate, Date toDate,String cat,String inout,Long deptid,Long ftype,Long fileOrLetterCatetogy,String Otherthandept,String subject) {
		return commonDao.fetchAdvanceSearchEngineDataAdmin(fromDate,toDate,cat,inout,deptid,ftype,fileOrLetterCatetogy,Otherthandept,subject);
	
	}
	public List fetchSearchEngineDatabyDepartment(Date fromDate, Date toDate, String cat, String inout, Long deptid, Long ftype, String otherthandept) {
		return commonDao.fetchSearchEngineDatabyDepartment(fromDate,toDate,cat,inout,deptid,ftype,otherthandept);
	}

	public List fetchAdvanceSearchEngineDatabyDepartment(Date fromDate,Date toDate, String cat, String inout, Long deptid, Long ftype,Long fileOrLetterCatetogy, String otherthandept, String subject) {
		return commonDao.fetchAdvanceSearchEngineDatabyDepartment(fromDate,toDate,cat,inout,deptid,ftype,fileOrLetterCatetogy,otherthandept,subject);
	}

	public void updateFinancialNo() {
		 commonDao.updateFinancialNo();
		
	}

	public Boolean CheckAlreadyExist(String tblName, String colmnName,String searchStr) {
		return commonDao.CheckAlreadyExist(tblName,colmnName,searchStr);
	}
	public List fetchOutwardRegister(Long deptid) {
		return commonDao.fetchOutwardRegister(deptid);
	
	}
	public List fetchOutbox(Long usmId) {
		return commonDao.fetchOutbox(usmId);
	
	}

	public List loadAllPayrollEmployeeData() {
		return commonDao.loadAllPayrollEmployeeData();
	}
	
}
