package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.ContactDetails;
import uk.org.datalink.MDR.domain.Country;
import uk.org.datalink.MDR.repository.JDBCContactDetailsDao;

public class ContactDetailsManager implements ContactDetailsDataManager{
	
	private static final long serialVersionUID = 1L;
	private JDBCContactDetailsDao contactDao;
	
	public JDBCContactDetailsDao getContactDao(){
		return contactDao;
	}
	
	public void setContactDao(JDBCContactDetailsDao  dao){
		this.contactDao = dao;
	}

	public int create(String tel, String email, int pid){
		
		ContactDetails ctdet = new ContactDetails();
		ctdet.setEmail(email);
		ctdet.setTelephone(tel);
		ctdet.setPid(pid);
		int contNo = this.contactDao.createContactDetails(ctdet);
		return contNo;
		 
	}
	public List<ContactDetails> getContactDetails(){
		return this.contactDao.getContactDetailsList();
	}
	public List<ContactDetails> getContactDetail(int id){
		List<ContactDetails> cdlist = contactDao.getContactDetails(id);
		return cdlist;
	}
	public void updateAddressDetails(ContactDetails cdObj){
		this.contactDao.updateContactDetails(cdObj);
	}
	public void deleteAll(){
		this.contactDao.deleteAllContactDetails();
	}
	public void delete(int id){
		this.contactDao.deleteContactDetails(id);
	}
	
	
}
