package uk.org.datalink.MDR.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.org.datalink.MDR.domain.AdminObject;
import uk.org.datalink.MDR.repository.AdminObjectDao;
import uk.org.datalink.MDR.repository.JDBCAdminObjectDao;

@Service
public class AdminObjectManager implements DataManager {
	
	private static final long serialVersionUID = 1L;
	private JDBCAdminObjectDao adminObjectDao;
	
	@Autowired
	public void setDao(JDBCAdminObjectDao  dao){
		this.adminObjectDao = dao;
	}
	
	public void setAdminObjectDao(JDBCAdminObjectDao  dao){
		this.adminObjectDao = dao;
	}
	
	public JDBCAdminObjectDao getAdminObjectDao(){
		return this.adminObjectDao;
	}
	
	public JDBCAdminObjectDao getDao(){
		return this.adminObjectDao;
	}
	
	public List<AdminObject> getAdminObjects() {
		return adminObjectDao.getAdminObjectList();
	}
	/*
	 *  This updates all the admin object to the same registration status - this is just a test routine
	 */
    public void setRegStatus(String status) {	
    	List<AdminObject> adminObjects = adminObjectDao.getAdminObjectList();
    	if(adminObjects!=null){
    		for (AdminObject obj : adminObjects) {
    			obj.setRegistrationStatus(status);
    			adminObjectDao.updateAdminObject(obj);
    		}
    	} 
    	
    }
    /*
     *  This gets the status of all objects but only returns last status - this is just a test routine
     */
    public int getAdminStatus() {	
    	int adminStatus = 9;
    	List<AdminObject> adminObjects = adminObjectDao.getAdminObjectList();
    	if(adminObjects!=null){
    		for (AdminObject obj : adminObjects) {
    			adminStatus = obj.getAdministrativeStatus();
    		}
    	} 
    	return adminStatus;
    }
    /*
     *  This updates all the admin object to the same registration status - this is just a test routine
     */
     public void setAdminStatus(int status) {
    	 List<AdminObject> adminObjects = adminObjectDao.getAdminObjectList();
    	if(adminObjects!=null){
    		for (AdminObject obj : adminObjects) {
    			obj.setAdministrativeStatus(status);
    			adminObjectDao.updateAdminObject(obj);
    		}
    	}
       
    }
    
 
    public void setAdminObjects(List<AdminObject> elements) {
    	List<AdminObject> adminObjects = elements;
    	if(adminObjects!=null){
    		for (AdminObject obj : adminObjects) {
    			adminObjectDao.updateAdminObject(obj);
    		}
    	} 	
    }

	public void create(int createdBy, int registeredBy,
			int adminObjectType, Date createdOn) {
			
		AdminObject ao = new AdminObject();
		ao.setCreatedby(createdBy);
		ao.setRegisteredby(registeredBy);
		ao.setAdminObjectType(adminObjectType);
		ao.setCreatedOn(createdOn);
		
		
		
	}


	public List<AdminObject> getAOList(int id) {
		
		List<AdminObject> adminObj = adminObjectDao.getAdminObjectList(id);
		return adminObj;
	}
	
	public AdminObject getAdminObject(int id) {
		
		AdminObject adminObj = adminObjectDao.getAdminObject(id);
		return adminObj;
	}


	public void deleteAll() {
		adminObjectDao.deleteAllAdminObjects();
		
	}


	public void delete(int id) {
		adminObjectDao.deleteAdminObject(id);
		
	}


	public void saveAdminObject(AdminObject obj) {
		adminObjectDao.toString();
		
	}

	public void updateAdminObject(AdminObject obj) {
		// TODO Auto-generated method stub
		
	}

    
	
	
}