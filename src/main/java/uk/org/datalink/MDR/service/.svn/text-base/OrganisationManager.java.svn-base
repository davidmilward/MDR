package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.Organisation;
import uk.org.datalink.MDR.repository.JDBCOrganisationDao;

public class OrganisationManager implements OrganisationDataManager {
	
	private static final long serialVersionUID = 1L;
	private JDBCOrganisationDao organisationDao;
	
	public void setOrganisationDao(JDBCOrganisationDao orDao){
		this.organisationDao = orDao;
	}
	
	public JDBCOrganisationDao getOrganisationDao(){
		return this.organisationDao;
	}
	public int create(String name, String description, int Contactid, String  orgMail ){
		int oid = 0;
		Organisation orgObj = new Organisation();
		orgObj.setContactid(Contactid);
		orgObj.setDescription(description);
		orgObj.setName(name);
		orgObj.setOrganisationemail(orgMail);
		oid = organisationDao.createOrganisation(orgObj);
		return oid;	
	}
	public int create(Organisation orgObj  ){
		int oid = organisationDao.createOrganisation(orgObj);
		return oid;	
	}
	public List<Organisation> getOrganisations(){
		List<Organisation> orglist = organisationDao.getOrganisationList();
		return orglist;
	}
	public List<Organisation> getOrganisation(int id){
		List<Organisation> orglist = organisationDao.getOrganisation(id);
		return orglist;
	}
	public void updateOrganisation(Organisation obj){
		this.organisationDao.updateOrganisation(obj);
	}
	public void deleteAll(){
		this.organisationDao.deleteAllOrganisations();
	}
	public void delete(int id){
		this.organisationDao.deleteOrganisation(id);
	}
	
}
