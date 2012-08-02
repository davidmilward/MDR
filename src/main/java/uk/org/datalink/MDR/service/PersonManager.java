package uk.org.datalink.MDR.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;
import uk.org.datalink.MDR.domain.Person;
import uk.org.datalink.MDR.repository.JDBCPersonDao;

@Service
public class PersonManager implements PersonDataManager{
	
	private static final long serialVersionUID = 1L;
	private JDBCPersonDao personDao;
	
	@Autowired
	public void setPersonDao(JDBCPersonDao pd){
		this.personDao = pd;
	}
	
	public JDBCPersonDao getPersonDao(){
		return this.personDao;
	}
	
	
	public int create(String title, String firstname, String surname, String  othernames, String alias, Date dob, String notes ){
		int pid = 0;
		Person perObj = new Person();
		perObj.setTitle(title);
		perObj.setFirstname(firstname);
		perObj.setSurname(surname);
		perObj.setOtherNames(othernames);
		perObj.setAlias(alias);
		perObj.setDob(dob);
		perObj.setNotes(notes);
		pid = personDao.createPerson(perObj);
		return pid;	
	}
	
	public int create(Person psn ){
		int pid = personDao.createPerson(psn);
		return pid;	
	}
	
	public List<Person> getPersons(){
		return this.personDao.getPeopleList();
	}
	public List<Person> getPersonList(int id){
		return this.personDao.getPeopleList();	
	}
	public Person getPerson(int id){
		return this.personDao.getPerson(id);
	}
	public void updatePerson(Person psnObj){
		this.personDao.updatePerson(psnObj);
	}
	public void deleteAll(){
		this.personDao.deleteAllPersons();
	}
	public void delete(int id){
		this.personDao.deletePerson(id);
	}
}
