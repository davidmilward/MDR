package uk.org.datalink.MDR.repository;

import java.util.ArrayList;
import java.util.List;

import uk.org.datalink.MDR.domain.ContactDetails;

public interface ContactDetailsDao {
	public ArrayList<ContactDetails> getContactDetailsList();
	public void updateContactDetails(ContactDetails cntObj);
	public int createContactDetails(ContactDetails cntObj);
	public List<ContactDetails> getContactDetails(int id);
	public void deleteAllContactDetails();
	public void deleteContactDetails(int id);
}
