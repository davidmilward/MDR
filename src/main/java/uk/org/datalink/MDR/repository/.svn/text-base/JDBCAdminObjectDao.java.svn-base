package uk.org.datalink.MDR.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uk.org.datalink.MDR.domain.AdminObject;
import uk.org.datalink.MDR.domain.Person;
import uk.org.datalink.MDR.domain.Term;



@Repository
public class JDBCAdminObjectDao implements AdminObjectDao{

	 /** Logger for this class and subclasses */
	private final Logger logger = LoggerFactory.getLogger(getClass());
	protected SimpleJdbcTemplate simpleJdbcTemplate;
	private SimpleJdbcInsert insertAdminObj;
	protected DataSource dataSource;
	private final List<AdminObject> objects = new ArrayList<AdminObject>();
	
	public JDBCAdminObjectDao(){
		
	}
	
	@Autowired
	public JDBCAdminObjectDao(DataSource dSource){
		this.dataSource = dSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	 
	@Autowired
	public void setDataSource(DataSource dSource) {
		this.dataSource = dSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dSource);
	}

	@Transactional(readOnly = true)
    public void saveAdminObject(AdminObject obj) {
        logger.info("Saving adminobject: " + obj.getAdministrativeStatus());
        int count = this.simpleJdbcTemplate.update(
            "update adminobject set " +
            "comments = :comments, " +
            "registrationstatus = :registrationstatus, " +
            "administrativestatus = :administrativestatus " +
            "where id = :id",
            new MapSqlParameterSource().addValue("comments", obj.getComments())
                .addValue("registrationstatus", obj.getRegistrationStatus())
                .addValue("administrativestatus", obj.getAdministrativeStatus())
                .addValue("id", obj.getAdminobjectid()));
        logger.info("Rows affected: " + count);
    }
    
    public ArrayList<AdminObject> getAdminObjectList() {
        logger.info("Getting objects!");
        ArrayList<AdminObject> objects = (ArrayList) this.simpleJdbcTemplate.query(
                "select id, comments, registrationstatus, administrativestatus from adminobject", 
                new AdminObjectMapper());
        return objects;
    }	
    
    private static class AdminObjectMapper implements ParameterizedRowMapper<AdminObject> {

        public AdminObject mapRow(ResultSet rs, int rowNum) throws SQLException {
        	AdminObject obj = new AdminObject();
            obj.setAdminobjectid(rs.getInt("id"));
            obj.setComments(rs.getString("comments"));
            obj.setAdministeredby(rs.getInt("administeredby"));
            //obj.setAdministrativeStatus(rs.getString("admin_status"));
            //obj.setClassification(classif);
            obj.setClassifiedby(rs.getInt("classifiedby"));
            obj.setCreatedby(rs.getInt("createdby"));
            obj.setCreatedOn(rs.getDate("createdon"));
            obj.setDateFirstActive(rs.getDate("datefirstactive"));
            obj.setDateFirstInactive(rs.getDate("datefirstinactive"));
            obj.setLastModifiedby(rs.getInt("lastmodifiedby"));
            obj.setLastModifiedOn(rs.getDate("lastmodifiedon"));
            obj.setRegisteredby(rs.getInt("registeredby"));
            obj.setRegisteredOn(rs.getDate("registeredon"));
            obj.setSubmittedby(rs.getInt("submittedby"));
            obj.setRegistrationStatus(rs.getString("registrationstatus"));
            obj.setAdministrativeStatus(rs.getInt("administrativestatus"));
            return obj;
        }
    }
    @SuppressWarnings("deprecation")
	@Transactional
	public void updateAdminObject(AdminObject obj) {
    	AdminObject adObj = (AdminObject)obj;
		logger.info("Updating adminobject: " + obj.toString());
        int count = this.simpleJdbcTemplate.update(
            "UPDATE adminobject SET comments = :comments, " +
            "registrationstatus = :registrationstatus, " +
            "administeredby = :administeredby, " +
            "submittedby = :submittedby " +
            "WHERE id = :id",
            new MapSqlParameterSource().addValue("comments", obj.getComments())
                .addValue("registrationstatus", obj.getRegistrationStatus())
                .addValue("administeredby", obj.getAdministeredby())
                .addValue("submittedby", obj.getSubmittedby())
                .addValue("id", adObj.getAdminobjectid()));
        logger.info("Rows affected: " + count);

        
        String update = "UPDATE adminobject SET classifiedby = ?, classification = ?,administrativestatus = ? WHERE id = ?";
        int ret = simpleJdbcTemplate.update(update,obj.getClassifiedby(),obj.getClassification(),obj.getAdministrativeStatus(), adObj.getAdminobjectid());
            logger.info("UPDATE2:Rows affected: " + ret + obj.getClassifiedby() + ":" + obj.getClassification() + ":" + obj.getAdministrativeStatus() + ":" + adObj.getAdminobjectid() );
	}
    @Transactional(readOnly = true)
	public int createAdminObject(int createdBy, int registeredBy, int  adminObjectType, Date createdOn){
		    logger.info("createAdminObject, createdBy= " + createdBy);
		    logger.info("createAdminObject, registeredBy= " + registeredBy);
		    logger.info("createAdminObject, adminObjectType= " + adminObjectType);
		    logger.info("createAdminObject, createdOn= " + createdOn);
		    if(this.simpleJdbcTemplate==null){logger.info("createAdminObject, Oh Fuck! " );}
		    int adminNo = 0;
		    if(createdOn!=null){
				int count = this.simpleJdbcTemplate.update("INSERT INTO ADMINOBJECT (CREATEDBY, REGISTEREDBY, ADMINTYPE, CREATEDON) VALUES(?,?,?,?)",
				new Object[] { createdBy, registeredBy, adminObjectType, createdOn });
		        logger.info("Rows affected: " + count);
		        String adminNoSQL = "select last_value from seq_adm" ;
		        TreeMap empty = null;
		        adminNo = this.simpleJdbcTemplate.queryForInt(adminNoSQL,empty);
	        }
	        return adminNo;
	}
    @Transactional(readOnly = true)
	public int createAdminObject(AdminObject ao){
	    logger.info("createAdminObject1, RegistrationStatus= " + ao.getRegistrationStatus());
	    logger.info("createAdminObject2, RegisteredBy= " + ao.getRegisteredby());
	    logger.info("createAdminObject3, AdministeredBy= " + ao.getAdministeredby());
	    logger.info("createAdminObject4, Submittedby= " + ao.getSubmittedby());
	    logger.info("createAdminObject5, ClassifiedBy= " + ao.getClassifiedby());
	    logger.info("createAdminObject6, LastModifiedOn= " + ao.getLastModifiedOn());
	    logger.info("createAdminObject7, CreatedOn= " + ao.getCreatedOn());
	    logger.info("createAdminObject8, AdminObjectType= " + ao.getAdminObjectType());
	    logger.info("createAdminObject9, comments= " + ao.getComments());
	    logger.info("createAdminObject10, getDateFirstActive= " + ao.getDateFirstActive());
	    logger.info("createAdminObject11, CreatedBy= " + ao.getCreatedby());
	    logger.info("createAdminObject12, LastModifiedBy= " + ao.getLastModifiedby());
	    logger.info("createAdminObject13, RegisteredOn= " + ao.getRegisteredOn());
	    logger.info("createAdminObject14, Classification= " + ao.getClassification());
	    logger.info("createAdminObject15, AdministrativeStatus= " + ao.getAdministrativeStatus());
	    int adminNo = 0;
	    if(this.simpleJdbcTemplate == null){
	    	   logger.info("Fuck DI");
	    	   
	    }
		int count = this.simpleJdbcTemplate.update("INSERT INTO ADMINOBJECT ( registrationstatus, registeredby, administeredby, submittedby, " +
				"classifiedby, lastmodifiedon, createdon, admintype, comments, datefirstactive, " +
				"createdby, lastmodifiedby, registeredon, classification, administrativestatus" +
				") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
		new Object[] {ao.getRegistrationStatus(),ao.getRegisteredBy(),ao.getAdministeredBy(),ao.getSubmittedby(),
				ao.getClassifiedBy(), ao.getLastModifiedOn(),ao.getCreatedOn(), ao.getAdminObjectType(), ao.getComments(), ao.getDateFirstActive(), 
				ao.getCreatedBy(), ao.getLastModifiedBy(), ao.getRegisteredOn(), ao.getClassification(), ao.getAdministrativeStatus()});
		
	    logger.info("Rows affected: " + count);
	    
	    String adminNoSQL = "select last_value from seq_adm" ;
	    TreeMap empty = null;
	    adminNo = this.simpleJdbcTemplate.queryForInt(adminNoSQL,empty);
        
        return adminNo;
}


	public List<AdminObject> getAdminObjectList(int id) {
		logger.info("getAdminObject, id= " + id);
		ArrayList<AdminObject> objects = (ArrayList)this.simpleJdbcTemplate.query(
                "select id, comments, registrationstatus, administrativestatus from adminobject where id=" + id, 
                new AdminObjectMapper());
		return objects;
	}
	
	public AdminObject getAdminObject(int adminid) {
//		logger.info("getAdminObject, id= " + id);
//		AdminObject adobj;
//		try {
//			adobj = this.simpleJdbcTemplate.queryForObject(
//			"select id, comments, registrationstatus, administrativestatus from adminobject where id=?",
//			ParameterizedBeanPropertyRowMapper.newInstance(AdminObject.class),id);
//		}
//		catch (EmptyResultDataAccessException ex) {
//			throw new ObjectRetrievalFailureException(Person.class, new Integer(id));
//		}
//		return adobj;
		AdminObject  ao = new AdminObject();
		Person regBy = new Person();
		Person createdBy  = new Person();
		Person lastModifiedBy = new Person();
		Person submittedBy = new Person();
		Person classifiedBy = new Person();
		Person administeredBy = new Person();
        ao =  getAdminObjCore(adminid);
		
		logger.info("Admin Obj, id= " + adminid);

		logger.info("registeredby");
		int nRegBy = ao.getRegisteredby();
		logger.info("registeredby, id= " + nRegBy);
		if(nRegBy > 0){
			regBy =  getPerson(nRegBy,  regBy);
			ao.setRegisteredBy(regBy);
			ao.setRegisterer(regBy.getFullName());
			logger.info("registeredby, id= " + regBy.getFullName());
		}
		
		int nCreBy = ao.getCreatedby();
		logger.info("createdBy, id= " + nCreBy);
		if(nCreBy > 0){
			createdBy =  getPerson(nCreBy,  createdBy);
			ao.setRegisteredBy(createdBy);
			ao.setRegisterer(createdBy.getFullName());
			logger.info("createdBy, id= " + createdBy.getFullName());
		}
		
		int nLastMBy = ao.getLastModifiedby();
		logger.info("lastModifiedBy, id= " + nLastMBy);
		if(nLastMBy > 0){
			lastModifiedBy =  getPerson(nLastMBy,  lastModifiedBy);
			ao.setLastModifiedBy(lastModifiedBy);
			ao.setLModifier(lastModifiedBy.getFullName());
			logger.info("lastModifiedBy, id= " + lastModifiedBy.getFullName());
		}
		
		int nSubBy = ao.getSubmittedby();
		logger.info("submittedBy, id= " + nSubBy);
		if(nSubBy > 0){
			submittedBy =  getPerson(nSubBy,  submittedBy);
			ao.setSubmittedBy(submittedBy);
			ao.setSubmitter(submittedBy.getFullName());
			logger.info("submittedBy, id= " + submittedBy.getFullName());
		}
		
		int nClassBy = ao.getClassifiedby();
		logger.info("classifiedBy, id= " + nClassBy);
		if(nClassBy > 0){
			classifiedBy =  getPerson(nClassBy,  classifiedBy);
			ao.setClassifiedBy(classifiedBy);
			ao.setClassifier(classifiedBy.getFullName());
			logger.info("classifiedBy, id= " + classifiedBy.getFullName());
		}
		
		int nAdBy = ao.getAdministeredby();
		logger.info("administeredBy, id= " + nAdBy);
		if(nAdBy > 0){
			administeredBy =  getPerson(nAdBy,  administeredBy);
			ao.setAdministeredBy(administeredBy);
			ao.setAdminster(administeredBy.getFullName());
			logger.info("administeredBy, id= " + ao.getAdministeredBy().getFullName());
		}
		
		return ao;
	}
	
	@SuppressWarnings("deprecation")
	@Transactional
	private Person getPerson(int personID, Person regBy){		
		try {
			regBy = this.simpleJdbcTemplate.queryForObject(
					"select id, title, firstname, surname, othernames, alias, dob, notes from person where id=?",
					ParameterizedBeanPropertyRowMapper.newInstance(Person.class), personID);
		}
		catch (EmptyResultDataAccessException ex) {
			throw new ObjectRetrievalFailureException(Term.class, new Integer(personID));
		}
		return regBy;
	}
	@Transactional
	private AdminObject getAdminObjCore(int id){
		AdminObject admin;
		logger.info("getAdminObj: " + id);
		try {
			admin = this.simpleJdbcTemplate.queryForObject(
					"SELECT id, registrationstatus, registeredby, administeredby, lastmodifiedby, " +
					"submittedby,classification,  classifiedby, createdby, administrativestatus," +
					"admintype, comments,createdon FROM adminobject WHERE id=?",
					ParameterizedBeanPropertyRowMapper.newInstance(AdminObject.class),
					id);
		}
		catch (EmptyResultDataAccessException ex) {
			throw new ObjectRetrievalFailureException(AdminObject.class, new Integer(id));
		}
		logger.info("gotAdminObj: " + admin.toString());
		return admin;
		
	}

	public void deleteAllAdminObjects() {
		logger.info("deleteAllAdminObjects");
		int count = this.simpleJdbcTemplate.update("DELETE FROM ADMINOBJECT");
        logger.info("Rows affected: " + count);
	}

	public void deleteAdminObject(int id) {
		logger.info("deleteAdminObject, id= " + id);
		int count = this.simpleJdbcTemplate.update("DELETE FROM ADMINOBJECT WHERE ID=" + id);
        logger.info("Rows affected: " + count);
	}

	public void setAdminObjectList(ArrayList<AdminObject> ol) {
		// TODO Auto-generated method stub
		
	}
	
}
