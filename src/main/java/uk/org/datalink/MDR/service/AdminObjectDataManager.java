package uk.org.datalink.MDR.service;

import java.util.Date;
import java.util.List;

import uk.org.datalink.MDR.domain.AdminObject;
import uk.org.datalink.MDR.repository.AdminObjectDao;


public class AdminObjectDataManager implements DataManager {
	
	private static final long serialVersionUID = 1L;
	private AdminObjectDao adminObjectDao;
	
	
	public void setDao(AdminObjectDao  dao){
		this.adminObjectDao = dao;
	}
	
	public void setAdminObjectDao(AdminObjectDao  dao){
		this.adminObjectDao = dao;
	}
	
	public AdminObjectDao getAdminObjectDao(){
		return this.adminObjectDao;
	}
	
	public AdminObjectDao getDao(){
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
    public int getAdminStatus(String status) {	
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
    			if(obj!=null){adminObjectDao.updateAdminObject(obj);}
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

	public List<AdminObject> getAO(int id) {
		
		List<AdminObject> adminObj = adminObjectDao.getAdminObjectList(id);
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

	public List<AdminObject> getAOList(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public AdminObject getAdminObject(int id) {
		AdminObject admObj = this.adminObjectDao.getAdminObject(id);
		return admObj;
	}

	public void updateAdminObject(AdminObject obj) {
		this.adminObjectDao.updateAdminObject(obj);
	}

    
	
	
}