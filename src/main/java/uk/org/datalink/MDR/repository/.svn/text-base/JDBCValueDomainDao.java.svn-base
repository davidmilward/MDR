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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uk.org.datalink.MDR.domain.AdminObject;
import uk.org.datalink.MDR.domain.DataElement;
import uk.org.datalink.MDR.domain.Datatype;
import uk.org.datalink.MDR.domain.Person;
import uk.org.datalink.MDR.domain.Term;
import uk.org.datalink.MDR.domain.UnitsOfMeasure;
import uk.org.datalink.MDR.domain.ValueDomain;

@Repository
public class JDBCValueDomainDao  {
	 /** Logger for this class and subclasses */
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@SuppressWarnings("deprecation")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private SimpleJdbcInsert insertAdminObj;
	private final List<ValueDomain> objects = new ArrayList<ValueDomain>();
    protected JDBCTermDao termDao;
    protected JDBCAdminObjectDao adminDao;
    protected JDBCDatatypeDao datatypeDao;
    protected JDBCUnitOfMeasureDao uomDao;
    protected DataSource dataSource;

    
//    public JDBCValueDomainDao(JDBCDatatypeDao dtDao) {
//    	this.datatypeDao = dtDao;
//    }
    
    
    @Autowired
	public void setDataSource(DataSource dSource) {
		this.dataSource = dSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dSource);
		setDao(dSource);
	}

	public void setDao(DataSource dSource) {
		this.adminDao = new JDBCAdminObjectDao(dSource);
		this.datatypeDao = new JDBCDatatypeDao(dSource);
		this.uomDao = new JDBCUnitOfMeasureDao(dSource);
		
	}


    @SuppressWarnings("deprecation")
	public ArrayList<ValueDomain> getValueDomainList() {
        logger.info("Getting ValueDomains!");
        @SuppressWarnings("unchecked")
		ArrayList<ValueDomain> objects = (ArrayList) this.simpleJdbcTemplate.query(
                "SELECT valuedomain.termid, datatype, maxchar,valuedomain.id," +
                "format,registrationstatus,registeredby,administeredby," +
                "submittedby,classifiedby,lastmodifiedon,createdon,admintype," +
                "unitofmeasure, adminobjectid, permissiblevalue,enumerated from adminobject,valuedomain,term WHERE" +
                " adminobject.id=valuedomain.adminobjectid " +
                " and valuedomain.termid=term.id " +
                " and term.id = valuedomain.termid",
                new ValueDomainMapper());
        

        return objects;
    }	
    
    
    

	@SuppressWarnings("deprecation")
	public void updateValueDomain(ValueDomain vd) {
		adminDao.saveAdminObject((AdminObject)vd);
        logger.info("Saving ValueDomain: " + vd.getValuedomainid());
        int count = this.simpleJdbcTemplate.update(
            "update valuedomain set " +
            "datatype = :datatype, " +
            "maxchar = :definition, " +
            "format = :format " +
            "unitofmeasure = :unitofmeasure " +
            "adminobjectid = :adminobjectid " +
            "permissiblevalue = :permissiblevalue " +
            "enumerated = :enumerated " +
            "termid = :termid " +
            "where id = :id",
            new MapSqlParameterSource().addValue("datatype", vd.getDatatype())
                .addValue("maxchar", vd.getMaxchar())
                .addValue("format", vd.getFormat())
                .addValue("unitofmeasure", vd.getUnitofmeasure())
		        .addValue("adminobjectid", vd.getAdminobjectid())
		        .addValue("permissiblevalue", vd.getPermissiblevalue())
		        .addValue("enumerated", vd.getEnumerated())
		        .addValue("termid", vd.getTermid()));
		        logger.info("Rows affected: " + count);
		
	}

	
	public int createValueDomain(ValueDomain vdObj){
		
		logger.info("create Value Domain, createdBy= " + vdObj.getComments());
		int adminObjId = adminDao.createAdminObject((AdminObject)vdObj);
		int count = this.simpleJdbcTemplate.update("INSERT INTO valuedomain (datatype,maxchar,format,unitofmeasure,adminobjectid,permissiblevalue,enumerated,termid) " +
				                  " VALUES(?,?,?,?,?,?,?,?)",
		new Object[] { vdObj.getDatatype(), vdObj.getMaxchar(), vdObj.getFormat(), vdObj.getUnitofmeasure(),adminObjId,
				vdObj.getPermissiblevalue(), vdObj.getEnumerated(), vdObj.getTermid()});
        logger.info("create Value Domain, Rows affected: " + count);
        String vdNoSQL = "select last_value from seq_vdm;" ;
        TreeMap empty = null;
        @SuppressWarnings("deprecation")
		int vdNo = this.simpleJdbcTemplate.queryForInt(vdNoSQL,empty);
        return vdNo;
		
	}

	
	@SuppressWarnings("deprecation")
	@Transactional(readOnly = true)
	public ValueDomain getValueDomain(int id) {
		logger.info("getValueDomain, id= " + id);
		ValueDomain vd = new ValueDomain();
		AdminObject  ao = new AdminObject();
		Term tm = new Term();
//		Person regBy = new Person();
//		Person createdBy  = new Person();
//		Person lastModifiedBy = new Person();
//		Person submittedBy = new Person();
//		Person classifiedBy = new Person();
//		Person administeredBy = new Person();
		
		try {
			vd = this.simpleJdbcTemplate.queryForObject(
			"select id, datatype, unitofmeasure, maxchar, format, adminobjectid, termid from valuedomain where id=?",
			ParameterizedBeanPropertyRowMapper.newInstance(ValueDomain.class),id);
		}
		catch (EmptyResultDataAccessException ex) {
			throw new ObjectRetrievalFailureException(ValueDomain.class, new Integer(id));
		}
        int adminid = vd.getAdminobjectid();
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

        //Datatype
        int dtid = vd.getDatatype();
        Datatype dt = this.datatypeDao.getDatatype(dtid);
        vd.setDataType(dt);
        
        //UnitOfMeasure
        int umid = vd.getUnitofmeasure();
        UnitsOfMeasure um = this.uomDao.getUnitsOfMeasure(umid);
        vd.setUnitsOfMeasure(um);
        
        
		logger.info("TERM, id= " + vd.getTermid());
		try {
			tm = this.simpleJdbcTemplate.queryForObject(
			"select id, description, term from term where id=?",
			ParameterizedBeanPropertyRowMapper.newInstance(Term.class),vd.getTermid());
		}
		catch (EmptyResultDataAccessException ex) {
			throw new ObjectRetrievalFailureException(Term.class, new Integer(id));
		}
		vd = fuseVD(vd,ao,tm);
		return vd;
	}

	public void deleteAllValueDomains() {
		logger.info("deleteAll ValueDomain");
		int count = this.simpleJdbcTemplate.update("DELETE * FROM valuedomain");
        logger.info("Rows affected: " + count);
		
	}

	public void deleteValueDomain(int id) {
		logger.info("delete value domain, id= " + id);
		int count = this.simpleJdbcTemplate.update("DELETE * FROM valuedomain WHERE ID=" + id);
        logger.info("Rows affected: " + count);
		
	}
	
	public Term searchTerm(String tm){
		return termDao.search(tm);
	}
	
//	@SuppressWarnings("deprecation")
//	@Transactional
//	private Person getPerson(int personID, Person regBy){		
//		try {
//			regBy = this.simpleJdbcTemplate.queryForObject(
//					"select id, title, firstname, surname, othernames, alias, dob, notes from person where id=?",
//					ParameterizedBeanPropertyRowMapper.newInstance(Person.class), personID);
//		}
//		catch (EmptyResultDataAccessException ex) {
//			throw new ObjectRetrievalFailureException(Term.class, new Integer(personID));
//		}
//		return regBy;
//	}
//	@Transactional
//	private AdminObject getAdminObj(int id){
//		AdminObject admin;
//		logger.info("getAdminObj: " + id);
//		try {
//			admin = this.simpleJdbcTemplate.queryForObject(
//					"SELECT id, registrationstatus, registeredby, administeredby, lastmodifiedby, " +
//					"submittedby,classification,  classifiedby, createdby, administrativestatus," +
//					"admintype, comments,createdon FROM adminobject WHERE id=?",
//					ParameterizedBeanPropertyRowMapper.newInstance(AdminObject.class),
//					id);
//		}
//		catch (EmptyResultDataAccessException ex) {
//			throw new ObjectRetrievalFailureException(AdminObject.class, new Integer(id));
//		}
//		logger.info("gotAdminObj: " + admin.toString());
//		return admin;
//		
//	}
	
	private static class ValueDomainMapper implements ParameterizedRowMapper<ValueDomain> {

        public ValueDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
        	ValueDomain vd = new ValueDomain();
        	vd.setDatatype(rs.getInt("datatype"));
        	vd.setMaxchar(rs.getInt("maxchar"));
        	vd.setFormat(rs.getString("format"));
        	vd.setValuedomainid(rs.getInt("id"));
        	vd.setUnitofmeasure(rs.getInt("unitofmeasure"));
        	vd.setAdminobjectid(rs.getInt("adminobjectid"));
        	vd.setPermissiblevalue(rs.getInt("permissiblevalue"));
        	vd.setEnumerated(rs.getBoolean("enumerated"));
        	vd.setTermid(rs.getInt("termid"));
            return vd;
        }

    }
	private ValueDomain fuseVD(ValueDomain vd, AdminObject ao, Term te){
		vd.setAdministeredBy(ao.getAdministeredBy());
		vd.setAdministrativeStatus(ao.getAdministrativeStatus());
		vd.setAdminObjectType(ao.getAdminObjectType());
		vd.setClassification(ao.getClassification());
		vd.setClassifiedBy(ao.getClassifiedBy());
		vd.setComments(ao.getComments());
		vd.setCreatedBy(ao.getCreatedBy());
		vd.setCreatedOn(ao.getCreatedOn());
		vd.setDateFirstActive(ao.getDateFirstActive());
		vd.setDateFirstInactive(ao.getDateFirstInactive());
		vd.setLastModifiedBy(ao.getLastModifiedBy());
		vd.setLastModifiedOn(ao.getLastModifiedOn());
		vd.setRegisteredBy(ao.getRegisteredBy());
		vd.setRegisteredOn(ao.getRegisteredOn());
		vd.setRegistrationStatus(ao.getRegistrationStatus());
		vd.setSubmittedby(ao.getSubmittedby());
		vd.setTerm(te);
		vd.setAdministeredBy(ao.getAdministeredBy());
		vd.setClassifiedBy(ao.getClassifiedBy());
		vd.setCreatedBy(ao.getClassifiedBy());
		vd.setLastModifiedBy(ao.getLastModifiedBy());
		vd.setRegisteredBy(ao.getRegisteredBy());
		vd.setSubmittedBy(ao.getSubmittedBy());
		return vd;
	}


}

