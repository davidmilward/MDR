package uk.org.datalink.MDR.domain;
	
import java.util.Date;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.org.datalink.MDR.domain.Person;

/**
 * 
 * <p>This is the key parent class for the main business objects in the metadata registy </p> 
 * <p>It holds details on who did what to the object, namely:</p> 
 * <p><ul> </p> 
 * <p><li>createdby</li></p> 
 * <p><li>lastModifiedby</li></p> 
 * <p><li>registeredby</li></p> 
 * <p><li>submittedby</li></p> 
 * <p><li>classifiedby</li></p> 
 * <p><li>administeredby</li></p>    
 * <p></ul></p> 
 *  
 *
 * @author David Milward
 * @version %I%, %G%
 */
public class AdminObject implements Serializable {

		private static final long serialVersionUID = 1L;
		public static final int adminObjectTypeDataElement = 0;
		public static final int adminObjectTypeValueDomain = 1;
		public static final int adminObjectTypeModel = 2;
		public static final int adminObjectTypeClassificationScheme = 3;
		 /** Logger for this class and subclasses */
		private final Logger logger = LoggerFactory.getLogger(getClass());
		
		private int adminobjectid;
		private int adminObjectType;
		private int administrativeStatus;
		
		private int createdby;
		private int lastModifiedby;
		private int registeredby;
		private int submittedby;
		private int classifiedby;
		private int administeredby;

		private Person submittedBy;
		private Person classifiedBy;
		private Person administeredBy;
		private Person createdBy;
		private Person lastModifiedBy;
		private Person registeredBy;

		private String comments;
		private String registrationStatus;
		private String classification;
		
		private Term term;

		private Date dateFirstActive;
		private Date dateFirstInactive;
		private Date createdOn;
		private Date lastModifiedOn;
		private Date registeredOn;


		
		public void setTermString(String tm){
			this.term.setTerm(tm);
		}
		public String getTermString(){
			return this.term.getTerm();
		}
		public String getTermDescription(){
			return this.term.getDescription();
		}
		public void setTerm(Term tm){
			this.term=tm;
		}
		public Term getTerm(){
			return this.term;
		}
		
		
		public int getAdminobjectid(){
			return this.adminobjectid;
		};
		public void setAdminobjectid(int nid){
			this.adminobjectid = nid;
		}

		public String getComments(){
			return this.comments;
		}
		public void setComments(String comment1){
			this.comments = comment1;
		}
		public Date getDateFirstActive(){
			return this.dateFirstActive;
		};
		public void setDateFirstActive(Date first){
			this.dateFirstActive = first;
		};
		public Date getDateFirstInactive(){
			return this.dateFirstInactive;
		};
		public void setDateFirstInactive(Date FirstIn){
			this.dateFirstInactive = FirstIn;
		};
		public Person getCreatedBy(){
		    return this.createdBy;	
		};
		public void setCreatedBy(Person i){
		    this.createdBy = i;	
		};
		public Date getCreatedOn(){
			return this.createdOn;
		};
		public void setCreatedOn(Date createdon){
			this.createdOn = createdon;
		};
		public Date getLastModifiedOn(){
			return this.lastModifiedOn;
		};
		public void setLastModifiedOn(Date mod){
			this.lastModifiedOn = mod;
		};
		public Person getLastModifiedBy(){
			return this.lastModifiedBy;
		};
		public void setLastModifiedBy(Person modByWhom){
			this.lastModifiedBy = modByWhom ;
		};
		public String getRegistrationStatus(){
			return this.registrationStatus;
		};
		public void setRegistrationStatus(String rgring){
			this.registrationStatus = rgring;
		};
		public Person getRegisteredBy(){
			return this.registeredBy;
		};
		public void setRegisteredBy(Person regBy){
			this.registeredBy = regBy;
		};
		public Date getRegisteredOn(){
			return this.registeredOn;
		};
		public void setRegisteredOn(Date regOn){
			this.registeredOn = regOn;
		};
		public int getAdministrativeStatus(){
			return this.administrativeStatus;
		};
		public void setAdministrativeStatus(int adm){
			this.administrativeStatus = adm;
		};
		public Person getSubmittedBy(){
			return this.submittedBy;
		};
		public void setSubmittedBy(Person subBy){
			this.submittedBy = subBy;
		};
		public String  getClassification(){
			return this.classification;
		};
		public void setClassification(String classif){
			this.classification = classif;
		};

		public Person  getClassifiedBy(){
			return this.classifiedBy;
		};
		public void setClassifiedBy(Person classBy){
			this.classifiedBy = classBy;
		};
		
		public Person  getAdministeredBy(){
			return this.administeredBy;
		};
		public void setAdministeredBy(Person adminBy){
			logger.info("setAdministeredBy =" + adminBy.getFullName());
			this.administeredBy = adminBy;
		};
		public int  getAdminObjectType(){
			return this.adminObjectType;
		}; 
		public void setAdminObjectType(int adObjType){
			this.adminObjectType = adObjType;
		};
		

		
		public int getCreatedby(){
			return createdby;
		}
		public int getLastModifiedby(){
			return lastModifiedby;
		}
		public int getRegisteredby(){
			return this.registeredby;
		}
		public int getSubmittedby(){
			return this.submittedby;
		}
		public int getClassifiedby(){
			return classifiedby;
		}
		public int getAdministeredby(){
			return administeredby;
		}
		
		public void setCreatedby(int ref){
			this.createdby = ref;
		}
		public void setLastModifiedby(int ref){
			this.lastModifiedby = ref;
		}
		public void setRegisteredby(int ref){
			this.registeredby = ref;
		}
		public void setSubmittedby(int ref){
			this.submittedby = ref;
		}
		public void setClassifiedby(int ref){
			classifiedby = ref;
		}
		public void setAdministeredby(int ref){
			administeredby = ref;
		}
		
		
		
		public String getSubmitter(){
			if(this.submittedBy!=null){
				submitter = this.submittedBy.getFullName();
			}
			return submitter;
		}
		public String getClassifier(){
			if(this.classifiedBy!=null){
				classifier = this.classifiedBy.getFullName();
			}
			return classifier;
		}
		public String getAdminster(){
			if(administeredBy!=null){
				adminster = this.administeredBy.getFullName();
				 logger.info("1:administeredBy = " + adminster);
			}else{
			    logger.info("2:administeredBy = null");
			}
			return adminster;
		}
		public String getCreator(){
			if(this.createdBy!=null){
				creator = this.createdBy.getFullName();
			}
			return creator;
		}
		public String getLModifier(){
			if(this.lastModifiedBy!=null){
				lModifier = this.lastModifiedBy.getFullName();
			}
			return lModifier;
		}
		public String getRegisterer(){
			if(this.registeredBy!=null){
				registerer = this.registeredBy.getFullName();
			}
			return registerer;
		}
		private String submitter = "no-one";
		private String classifier= "no-one";
		private String adminster= "no-one";
		private String creator= "no-one";
		private String lModifier= "no-one";
		private String registerer= "no-one";
		
		public void setSubmitter(String sub){
			this.submitter = sub;
		}
		public void setClassifier(String sub){
			this.classifier = sub;
		}
		public void setAdminster(String sub){
			this.adminster = sub;
		}
		public void setCreator(String sub){
			this.creator = sub;
		}
		public void setLModifier(String sub){
			this.lModifier = sub;
		}
		public void setRegisterer(String sub){
			this.registerer = sub;
		}
		

		
		
		
		
		public String toString() {
		  StringBuffer buffer = new StringBuffer();
		  buffer.append("AdminObject - AdminObjID=:" + this.getAdminobjectid()+ ";" + "\r\n" );
		  buffer.append("AdminObject - Comments:" + this.comments + ";" + "\r\n" );
		  buffer.append("AdminObject - Type:" + this.getAdministeredby() + ";" + "\r\n");
		  buffer.append("AdminObject - classification:" + this.getClassification() + ";" + "\r\n");
		  buffer.append("AdminObject - administeredBy:" + this.getAdministeredby() + ";" + "\r\n");
		  buffer.append("AdminObject - administrativeStatus:" + this.administrativeStatus + ";" + "\r\n");
		  buffer.append("AdminObject - RegisteredBy:" +  this.getRegisteredby() + ";" + "\r\n");
		  buffer.append("AdminObject - RegisteredBy:" +  this.getRegisteredby() + "\r\n");
          buffer.append("AdminObject - getAdministeredby:" +  this.getAdministeredby() + "\r\n");
          buffer.append("AdminObject - getSubmittedby:" +  this.getSubmittedby() + "\r\n");
          buffer.append("AdminObject - getClassifiedby:" +  this.getClassifiedby() + "\r\n");
          buffer.append("AdminObject - getLastModifiedOn:" +  this.getLastModifiedOn() + "\r\n");
          buffer.append("AdminObject - getAdminObjectType:" +  this.getAdminObjectType() + "\r\n");
          buffer.append("AdminObject - getLastModifiedBy:" +  this.getLastModifiedBy() + "\r\n");
          buffer.append("AdminObject - getRegisteredOn:" +  this.getRegisteredOn() + "\r\n");
          buffer.append("AdminObject - getClassifiedby:" +  this.getClassifiedby() + "\r\n");
          buffer.append("AdminObject - getAdministrativeStatus:" +  this.getAdministrativeStatus() + "\r\n");
          buffer.append("AdminObject - getRegistrationStatus:" +  this.getRegistrationStatus() + "\r\n");
	      return buffer.toString();
		}
		
}
