package uk.org.datalink.MDR.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import uk.org.datalink.MDR.domain.AdminObject;
import uk.org.datalink.MDR.domain.Person;

public interface DataManager extends Serializable{

	public void create(int createdBy, int registeredBy, int  adminObjectType, Date createdOn );
	public List<AdminObject> getAdminObjects();
	public List<AdminObject> getAOList(int id);
	public AdminObject getAdminObject(int id);
	public void updateAdminObject(AdminObject obj); 
	public void setAdminStatus(int status);
	public void deleteAll();
	public void delete(int id);

}
