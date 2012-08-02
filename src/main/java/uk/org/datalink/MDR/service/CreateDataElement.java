package uk.org.datalink.MDR.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class CreateDataElement {
    private String term;
    private String description;
    private String definition;
    private String registrationstatus;
    private int registeredby;
    private int administeredby;
    private int submittedby;
    private int classifiedby;
    private String comments;
    private String classification;
    private int administrativestatus;
    private int classificationSchemeID;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	public void setTerm(String nstatus){
		this.term = nstatus;
	}
	public String getTerm(){
		return this.term;
	}
	public void setDescription(String des){
		this.description = des;
	}
	public String getDescription(){
		return this.description;
	}
	public void setDefinition(String def){
		this.definition = def;
	}
	public String getDefinition(){
		return this.definition;
	}
	public void setRegistrationstatus(String reg){
		this.registrationstatus = reg;
	}
	public String getRegistrationstatus(){
		return this.registrationstatus;
	}
	public void setRegisteredby(int reg){
		this.registeredby = reg;
	}
	public int getRegisteredby(){
		return this.registeredby;
	}
	public void setAdministeredby(int adm){
		this.administeredby = adm;
	}
	public int getAdministeredby(){
		return this.administeredby;
	}
	public void setSubmittedby(int sub){
		this.submittedby = sub;
	}
	public int getSubmittedby(){
		return this.submittedby;
	}
	public void setClassifiedby(int cls){
		this.classifiedby = cls;
	}
	public int getClassifiedby(){
		return this.classifiedby;
	}
	public void setComments(String cmts){
		this.comments = cmts;
	}
	public String getComments(){
		return this.comments;
	}
	public void setClassification(String cls){
		this.classification = cls;
	}
	public String getClassification(){
		return this.classification;
	}
	public void setAdministrativestatus(int ast){
		this.administrativestatus = ast;
	}
	public int getAdministrativestatus(){
		return this.administrativestatus;
	}
	public void setClassificationSchemeID(int id){
		this.classificationSchemeID = id;
	}
	public int getClassificationSchemeID(){
		return this.classificationSchemeID;
	}
}
