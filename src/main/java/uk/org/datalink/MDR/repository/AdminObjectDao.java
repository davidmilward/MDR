package uk.org.datalink.MDR.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uk.org.datalink.MDR.domain.AdminObject;




public interface AdminObjectDao {

	public ArrayList<AdminObject> getAdminObjectList();
	public void setAdminObjectList(ArrayList<AdminObject> ol);
	public void updateAdminObject(AdminObject ao);
	public int createAdminObject(int createdBy, int registeredBy, int  adminObjectType, Date createdOn);
	public List<AdminObject> getAdminObjectList(int id);
	public AdminObject getAdminObject(int id);
	public void deleteAllAdminObjects();
	public void deleteAdminObject(int id);
	
	
	
	
}
