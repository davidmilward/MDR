package uk.org.datalink.MDR.service;


import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.org.datalink.MDR.domain.AdminObject;
import uk.org.datalink.MDR.domain.DataElement;
import uk.org.datalink.MDR.domain.Term;
import uk.org.datalink.MDR.repository.JDBCDataElementDao;
import uk.org.datalink.MDR.repository.JDBCPersonDao;
import uk.org.datalink.MDR.repository.JDBCTermDao;


@Service
public class DataElementManager extends AdminObjectManager {  
	
	private static final long serialVersionUID = 1L;
    protected final Log logger = LogFactory.getLog(getClass());
	private String Term;
	private JDBCDataElementDao deDao;
	private JDBCTermDao tmDao;
	
	
	@Autowired
	public void setDeDao(JDBCDataElementDao ddao){
		this.deDao = ddao;
	}
	
	public JDBCDataElementDao getDeDao(){
		return this.deDao;
	}
	@Autowired
	public void settmDao(JDBCTermDao tao){
		this.tmDao = tao;
	}
	
	public JDBCTermDao gettmDao(){
		return this.tmDao;
	}
	
	public void createDataElement(int createdBy, int registeredBy,int adminObjectType, Date createdOn) {
		DataElement de = new DataElement();
		de.setCreatedby(createdBy);
		de.setRegisteredby(registeredBy);
		de.setAdminObjectType(adminObjectType);
		de.setCreatedOn(createdOn);
		deDao.updateDataElement(de);		
		
	}
	
	public void createDataElement(DataElement de){
		
		deDao.createDataElement(de);
	}
	
	public int createDataElement(CreateDataElement cde){
		
		DataElement de = new DataElement();

		de.setRegisteredby(cde.getRegisteredby());
        de.setAdministrativeStatus(cde.getAdministrativestatus());
        de.setAdminObjectType(AdminObject.adminObjectTypeDataElement); //data element
        de.setClassification(cde.getClassification());
        de.setComments(cde.getComments());
        de.setCreatedby(cde.getSubmittedby());
        de.setCreatedOn(new Date());
        de.setDateFirstActive(new Date());
        de.setDefinition(cde.getDefinition());
        de.setDescription(cde.getDescription());
        de.setLastModifiedby(cde.getSubmittedby());
        de.setLastModifiedOn(new Date());
        de.setRegisteredby(cde.getRegisteredby());
        de.setRegisteredOn(new Date());
        de.setRegistrationStatus(cde.getRegistrationstatus());
        de.setSubmittedby(cde.getSubmittedby());
        de.setAdministeredby(cde.getSubmittedby());
        String term = cde.getTerm();
        String tmDesc = cde.getDescription();

        Term newTerm = searchTerm(term);
        if(newTerm==null){
        	newTerm = createTerm(term,tmDesc);
        }
        de.setTerm(newTerm);
    	de.setTermID(newTerm.getId());
        

        int ref =  deDao.createDataElement(de);	
        return ref;
	}  
	
	protected Term searchTerm(String term){	
		return tmDao.search(term);
	}
	protected Term createTerm(String term, String desc){	
		Term newTerm = new Term();
		newTerm.setTerm(term);
		newTerm.setDescription(desc);
		int termid = tmDao.createTerm(newTerm);
		newTerm.setId(termid);
		return newTerm;
	}


	public List<DataElement> getDataElementList(int id) {
		List<DataElement> de = deDao.getDataElementList();
		return de;
	}
	
	public DataElement getDataElement(int id) {
		logger.info("DEM-getting data element:" + id);
		DataElement de = deDao.getDataElement(id);
		return de;
	}
	
	public List<DataElement> getDataElements(){
		List<DataElement> deList = deDao.getDataElementList();
		return deList;
	}


	public void deleteAll() {
		deDao.deleteAllDataElements();	
	}

	public void delete(int id){
		DataElement de = deDao.getDataElement(id);
		delete( de);
	}

	public void delete(DataElement de) {
		deDao.deleteDataElement(de);
	}


	public void updateDataElement(DataElement obj) {
		deDao.updateDataElement(obj);	
	}
	
	public void setTerm(String term){
		this.Term = term;
	}
	
	public String getTerm(){
		return this.Term;
	}



}
