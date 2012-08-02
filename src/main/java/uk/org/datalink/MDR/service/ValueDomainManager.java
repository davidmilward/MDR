package uk.org.datalink.MDR.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.org.datalink.MDR.domain.AdminObject;
import uk.org.datalink.MDR.domain.Term;
import uk.org.datalink.MDR.domain.ValueDomain;
import uk.org.datalink.MDR.repository.JDBCTermDao;
import uk.org.datalink.MDR.repository.JDBCValueDomainDao;
import uk.org.datalink.MDR.service.CreateValueDomain;


@Service
public class ValueDomainManager extends AdminObjectManager {

	private static final long serialVersionUID = 1L;
	private String Term;
	private JDBCValueDomainDao vdDao;
	private JDBCTermDao tmDao;
	
	@Autowired
	public void setTmDao(JDBCTermDao dao){
		this.tmDao = dao;
	}
	
	public JDBCTermDao getTmDao(){
		return this.tmDao;
	}
	
	@Autowired
	public void setVdDao(JDBCValueDomainDao vd){
		this.vdDao = vd;
	}
	
	public JDBCValueDomainDao getVdDao(){
		return this.vdDao;
	}
	
	public void createValueDomain(String createdBy, int datatype, int adminObjectType, Boolean enumerated, String fm, int mc, int pid, int uom, int aoid) {
		ValueDomain vd = new ValueDomain();
		vd.setDatatype(datatype);
		vd.setEnumerated(enumerated);
		vd.setFormat(fm);
		vd.setMaxchar(mc);
		vd.setPermissiblevalue(pid);
		vd.setUnitofmeasure(uom);
		vd.setAdminobjectid(aoid);
		vdDao.updateValueDomain(vd);
			
	}
	
	public int createValueDomain(ValueDomain vdObj){
		int ref = vdDao.createValueDomain(vdObj);
		return ref;
	}
	
	public int createValueDomain(CreateValueDomain cvd){
		ValueDomain vd = new ValueDomain();
		//to do - temporary - will change when datatype tables set up	 
		if(cvd.getDatatype()=="A"){
		    vd.setDatatype(1);
		}else{
			vd.setDatatype(2);
		}
		vd.setAdministrativeStatus(cvd.getAdministrativestatus());
		vd.setAdminObjectType(AdminObject.adminObjectTypeValueDomain); //value domain
		vd.setClassification(cvd.getClassification());
		vd.setClassifiedby(cvd.getClassifiedby());
		vd.setCreatedby(cvd.getSubmittedby());
		vd.setCreatedOn(new Date());
		vd.setDateFirstActive(new Date());
		if(cvd.getEnumerated()=="true"){
			vd.setEnumerated(true);
		}else{
			vd.setEnumerated(false);
		}

		vd.setFormat(cvd.getFormat());
		//to do - temporary - will change when permissible value tables set up	 
		if(cvd.getPermissiblevalue()=="A"){
		    vd.setPermissiblevalue(1);
		}else if (cvd.getPermissiblevalue()=="B"){
			vd.setPermissiblevalue(2);
		}else{
			vd.setPermissiblevalue(3);
		}
		
		//to do - temporary - will change when unit of measure  tables set up	 
		if(cvd.getUnitofmeasure()=="A"){
			vd.setUnitofmeasure(1);
		}else if (cvd.getUnitofmeasure()=="B"){
			vd.setUnitofmeasure(2);
		}else{
			vd.setUnitofmeasure(3);
		}
		
		
		vd.setLastModifiedby(cvd.getSubmittedby());
		vd.setLastModifiedOn(new Date());

		vd.setRegisteredOn(new Date());

		vd.setSubmittedby(cvd.getSubmittedby());
        String term = cvd.getTerm();
        String tmDesc = "Value Domain";

        Term newTerm = searchTerm(term);
        if(newTerm==null){
        	newTerm = createTerm(term,tmDesc);
        }
        vd.setTerm(newTerm);
    	vd.setTermid(newTerm.getId());
    	
    	vd.setComments(cvd.getComments());
    	vd.setFormat(cvd.getFormat());
    	vd.setAdministeredby(cvd.getAdministeredby());
    	vd.setRegisteredby(cvd.getRegisteredby());
    	vd.setRegistrationStatus(cvd.getRegistrationstatus());
        

    	int ref = vdDao.createValueDomain(vd);
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



	
	public ValueDomain getValueDomain(int id) {
		ValueDomain vde = vdDao.getValueDomain(id);
		return vde;
	}
	
	public List<ValueDomain> getValueDomains() {
		List<ValueDomain> de = vdDao.getValueDomainList();
		return de;
	}


	public void deleteAll() {
		vdDao.deleteAllValueDomains();	
	}

	public void delete(int id) {
		vdDao.deleteValueDomain(id);
	}

	public void updateValueDomain(ValueDomain obj) {
		vdDao.updateValueDomain(obj);	
	}
	
	public void setTerm(String term){
		this.Term = term;
	}
	
	public String getTerm(){
		return this.Term;
	}


	
	
}
