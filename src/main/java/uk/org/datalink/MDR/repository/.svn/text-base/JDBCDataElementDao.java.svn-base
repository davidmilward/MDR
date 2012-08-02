package uk.org.datalink.MDR.repository;

import java.sql.Connection;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import uk.org.datalink.MDR.domain.AdminObject;
import uk.org.datalink.MDR.domain.DataElement;
import uk.org.datalink.MDR.domain.Person;
import uk.org.datalink.MDR.domain.Term;



@Repository
public class JDBCDataElementDao {

	 /** Logger for this class and subclasses */
	private final Logger logger = LoggerFactory.getLogger(getClass());
    protected JDBCTermDao termDao;
    protected JDBCAdminObjectDao adminDao;
    protected DataSource dataSource;
    protected Connection connection = null;
	@SuppressWarnings("deprecation")
	protected SimpleJdbcTemplate simpleJdbcTemplate;
	protected JdbcTemplate jdbcTemplate;
	
	
	@SuppressWarnings("deprecation")
	@Autowired
	public void setDataSource(DataSource dSource){
		this.dataSource = dSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dSource);
		setAdminDao(dSource);
		jdbcTemplate = new JdbcTemplate(dSource);
	}

	public void setAdminDao(DataSource dSource) {
		this.adminDao = new JDBCAdminObjectDao(dSource);
	}
 
    @SuppressWarnings({ "deprecation" })
	public ArrayList<DataElement> getDataElementList() {
        logger.info("Getting data elements!");
        ArrayList<DataElement> objects = (ArrayList<DataElement>) this.simpleJdbcTemplate.query(
                "SELECT dataelement.termid, dataelement.description, definition,dataelement.id," +
                "registrationstatus,registeredby,administrativestatus,administeredby," +
                "submittedby,classifiedby,lastmodifiedon,createdon,admintype," +
                "comments from adminobject,dataelement,term WHERE" +
                " adminobject.id=dataelement.adminobjectid " +
                " and dataelement.termid=term.id " +
                " and term.id = dataelement.termid",
                new DataElementMapper());
        
        return objects;
    }	
    
    
    private static class DataElementMapper implements ParameterizedRowMapper<DataElement> {

        public DataElement mapRow(ResultSet rs, int rowNum) throws SQLException {
        	DataElement obj = new DataElement();
        	obj.setTermID(rs.getInt("termid"));
            obj.setDescription(rs.getString("description"));
            obj.setDefinition(rs.getString("definition"));
            obj.setDataElementId(rs.getInt("id"));
            obj.setRegistrationStatus(rs.getString("registrationstatus"));
            obj.setLastModifiedOn(rs.getDate("lastmodifiedon"));
            obj.setCreatedOn(rs.getDate("createdon"));
            obj.setAdminObjectType(rs.getInt("admintype"));
            obj.setComments(rs.getString("comments"));
            obj.setAdministrativeStatus(rs.getInt("administrativestatus"));
            return obj;
        }

    }

	@SuppressWarnings("deprecation")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void updateDataElement(DataElement de) {
		adminDao.updateAdminObject(de);
        logger.info("updateDataElement: " + de.toString());
        int count = this.simpleJdbcTemplate.update(
            "update dataelement set " +
            "description = :description, " +
            "definition = :definition, " +
            "adminobjectid = :adminobjectid " +
            "where id = :id",
            new MapSqlParameterSource().addValue("description", de.getDescription())
                .addValue("definition", de.getDefinition())
                .addValue("adminobjectid", de.getAdminobjectid())
                .addValue("classificationschemeid", de.getClassificationSchemeID())
                .addValue("id", de.getDataElementId()));
        logger.info("Rows affected: " + count);
		
	}

	@SuppressWarnings("deprecation")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public int createDataElement(DataElement deObj){
		
		logger.info("createDataElement, createdBy= " + deObj.getComments());
		int adminObjId = adminDao.createAdminObject((AdminObject)deObj);
		int count = this.simpleJdbcTemplate.update("INSERT INTO dataelement (description,definition,adminobjectid, termid) VALUES(?,?,?,?)",
		new Object[] { deObj.getDescription(), deObj.getDefinition(),adminObjId, deObj.getTermID()});
        logger.info("createDataElement, Rows affected: " + count);
        String adminNoSQL = "select last_value from seq_dte;" ;
        TreeMap empty = null;
        int adminNo = this.simpleJdbcTemplate.queryForInt(adminNoSQL,empty);
        return adminNo;
		
	}
	@SuppressWarnings("deprecation")
	@Transactional(readOnly = true)
	public DataElement getDataElement(int id) {
		logger.info("getDataElement, id= " + id);
		DataElement de = new DataElement();
		AdminObject  ao = new AdminObject();
		Term tm = new Term();
//		Person regBy = new Person();
//		Person createdBy  = new Person();
//		Person lastModifiedBy = new Person();
//		Person submittedBy = new Person();
//		Person classifiedBy = new Person();
//		Person administeredBy = new Person();
		try {
			
			de = this.simpleJdbcTemplate.queryForObject(
			"select id, adminobjectid,  description, definition, termid from dataelement where id=?",
			ParameterizedBeanPropertyRowMapper.newInstance(DataElement.class),id);
	
		}
		catch (EmptyResultDataAccessException ex) {
			throw new ObjectRetrievalFailureException(DataElement.class, new Integer(id));
		}
		int adminid = de.getAdminobjectid();
		ao = this.adminDao.getAdminObject(adminid);
//		ao =  getAdminObj(adminid);
//		
//		logger.info("Admin Obj, id= " + adminid);
//
//		logger.info("registeredby");
//		int nRegBy = ao.getRegisteredby();
//		logger.info("registeredby, id= " + nRegBy);
//		if(nRegBy > 0){
//			regBy =  getPerson(nRegBy,  regBy);
//			ao.setRegisteredBy(regBy);
//			ao.setRegisterer(regBy.getFullName());
//			logger.info("registeredby, id= " + regBy.getFullName());
//		}
//		
//		int nCreBy = ao.getCreatedby();
//		logger.info("createdBy, id= " + nCreBy);
//		if(nCreBy > 0){
//			createdBy =  getPerson(nCreBy,  createdBy);
//			ao.setRegisteredBy(createdBy);
//			ao.setRegisterer(createdBy.getFullName());
//			logger.info("createdBy, id= " + createdBy.getFullName());
//		}
//		
//		int nLastMBy = ao.getLastModifiedby();
//		logger.info("lastModifiedBy, id= " + nLastMBy);
//		if(nLastMBy > 0){
//			lastModifiedBy =  getPerson(nLastMBy,  lastModifiedBy);
//			ao.setLastModifiedBy(lastModifiedBy);
//			ao.setLModifier(lastModifiedBy.getFullName());
//			logger.info("lastModifiedBy, id= " + lastModifiedBy.getFullName());
//		}
//		
//		int nSubBy = ao.getSubmittedby();
//		logger.info("submittedBy, id= " + nSubBy);
//		if(nSubBy > 0){
//			submittedBy =  getPerson(nSubBy,  submittedBy);
//			ao.setSubmittedBy(submittedBy);
//			ao.setSubmitter(submittedBy.getFullName());
//			logger.info("submittedBy, id= " + submittedBy.getFullName());
//		}
//		
//		int nClassBy = ao.getClassifiedby();
//		logger.info("classifiedBy, id= " + nClassBy);
//		if(nClassBy > 0){
//			classifiedBy =  getPerson(nClassBy,  classifiedBy);
//			ao.setClassifiedBy(classifiedBy);
//			ao.setClassifier(classifiedBy.getFullName());
//			logger.info("classifiedBy, id= " + classifiedBy.getFullName());
//		}
//		
//		int nAdBy = ao.getAdministeredby();
//		logger.info("administeredBy, id= " + nAdBy);
//		if(nAdBy > 0){
//			administeredBy =  getPerson(nAdBy,  administeredBy);
//			ao.setAdministeredBy(administeredBy);
//			ao.setAdminster(administeredBy.getFullName());
//			logger.info("administeredBy, id= " + ao.getAdminster());
//		}
		
		
		try {
			tm = this.simpleJdbcTemplate.queryForObject(
			"select id, description, term from term where id=?",
			ParameterizedBeanPropertyRowMapper.newInstance(Term.class),de.getTermID());
		}
		catch (EmptyResultDataAccessException ex) {
			throw new ObjectRetrievalFailureException(Term.class, new Integer(id));
		}

		logger.info("TERM, id= " + de.getTermID());
		try {
			tm = this.simpleJdbcTemplate.queryForObject(
			"select id, description, term from term where id=?",
			ParameterizedBeanPropertyRowMapper.newInstance(Term.class),de.getTermID());
		}
		catch (EmptyResultDataAccessException ex) {
			throw new ObjectRetrievalFailureException(Term.class, new Integer(id));
		}

		
		
		de = fuseDE(de,ao,tm);
		logger.info("TERM, ad-id= " + de.getAdminobjectid());
		return de;
	}

	@SuppressWarnings("deprecation")
	public void deleteAllDataElements() {
		logger.info("deleteAllDataElements");
		int count = this.simpleJdbcTemplate.update("DELETE FROM DataElement");
        logger.info("Rows affected: " + count);
		
	}
	@SuppressWarnings("deprecation")
	@Transactional
	public void deleteDataElement(DataElement de) {
		int ref = de.getDataElementId();
		int adminRef = de.getAdminobjectid();
		logger.info("delete AdminObj, AOid= " + adminRef);
		adminDao.deleteAdminObject(adminRef);
		logger.info("deleteDataElement, id= " + ref);
		int count = this.simpleJdbcTemplate.update("DELETE FROM DATAELEMENT WHERE ID=" + ref);
        logger.info("Rows affected: " + count);
		
	}
	
	public Term searchTerm(String tm){
		return termDao.search(tm);
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
	private AdminObject getAdminObj(int id){
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
	@Transactional
	private DataElement fuseDE(DataElement de, AdminObject ao, Term te){
		de.setAdministeredby(ao.getAdministeredby());
		de.setAdministrativeStatus(ao.getAdministrativeStatus());
		de.setAdminObjectType(ao.getAdminObjectType());
		de.setClassification(ao.getClassification());
		de.setClassifiedby(ao.getClassifiedby());
		de.setComments(ao.getComments());
		de.setCreatedby(ao.getCreatedby());
		de.setCreatedOn(ao.getCreatedOn());
		de.setDateFirstActive(ao.getDateFirstActive());
		de.setDateFirstInactive(ao.getDateFirstInactive());
		de.setLastModifiedby(ao.getLastModifiedby());
		de.setLastModifiedOn(ao.getLastModifiedOn());
		de.setRegisteredby(ao.getRegisteredby());
		de.setRegisteredOn(ao.getRegisteredOn());
		de.setRegistrationStatus(ao.getRegistrationStatus());
		de.setSubmittedby(ao.getSubmittedby());
		de.setTerm(te);
		de.setAdministeredBy(ao.getAdministeredBy());
		de.setClassifiedBy(ao.getClassifiedBy());
		de.setCreatedBy(ao.getClassifiedBy());
		de.setLastModifiedBy(ao.getLastModifiedBy());
		de.setRegisteredBy(ao.getRegisteredBy());
		de.setSubmittedBy(ao.getSubmittedBy());
		
		return de;
	}

	
}
