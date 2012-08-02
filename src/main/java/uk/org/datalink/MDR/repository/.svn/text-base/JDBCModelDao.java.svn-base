package uk.org.datalink.MDR.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uk.org.datalink.MDR.domain.AdminObject;
import uk.org.datalink.MDR.domain.DataElement;
import uk.org.datalink.MDR.domain.Model;
import uk.org.datalink.MDR.domain.Term;

@Repository
public class JDBCModelDao implements ModelDao {
	
	 /** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	protected JDBCAdminObjectDao adminDao;
	protected DataSource dataSource;
	protected SimpleJdbcTemplate simpleJdbcTemplate;
	
   @Autowired
	public void setDataSource(DataSource dSource) {
		this.dataSource = dSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dSource);
		setAdminDao(dSource);
	}
   @Autowired
    public void setAdminDao(DataSource dSource) {
		this.adminDao = new JDBCAdminObjectDao(dSource);
	}

	public ArrayList<Model> getModelList(){
		logger.info("Getting Model list!");
       ArrayList<Model> models = (ArrayList) simpleJdbcTemplate.query(
               "select id, name, namespace, description, adminobjectid from model", new ModelMapper());
       return models;
	}

	public void updateModel(Model mlObj){
		logger.info("Updating Model: " + mlObj.getId());
       int count = simpleJdbcTemplate.update(
           "update model set name = :name, namespace = :namespace, description=description, adminobjectid=adminobjectid where id = :id",
           new MapSqlParameterSource().addValue("name", mlObj.getName())
               .addValue("namespace", mlObj.getNamespace())
               .addValue("description", mlObj.getDescription())
               .addValue("adminobjectid", mlObj.getAdminid())
               .addValue("id", mlObj.getId()));
       logger.info("Rows affected: " + count);
	}

	public void saveModel(Model mlObj){
		
		logger.info("createCountry, createdBy= " + mlObj.getName());
		int count = simpleJdbcTemplate.update("INSERT INTO country (name, namespace, description, adminobjectid) VALUES(?,?,?,?)",
		new Object[] { mlObj.getName(), mlObj.getNamespace(), mlObj.getDescription(), mlObj.getAdminobjectid()});
       logger.info("Rows affected: " + count);
	}
	public int createModel(Model mlObj){
		
		logger.info("create Model, createdBy= " + mlObj.getName());
		int adminObjId = adminDao.createAdminObject((AdminObject)mlObj);
		int count = simpleJdbcTemplate.update("INSERT INTO model (name, namespace, description, adminobjectid) VALUES(?,?,?,?)",
		new Object[] { mlObj.getName(), mlObj.getNamespace(), mlObj.getDescription(), adminObjId });
       logger.info("Rows affected: " + count);
       String adminNoSQL = "select last_value from seq_mdl;" ;
       TreeMap empty = null;
       int adminNo = simpleJdbcTemplate.queryForInt(adminNoSQL,empty);
       return adminNo;
	
	}

	public List<Model> getModelList(int id){
		
		logger.info("get model, id= " + id);
		ArrayList<Model> modellist = (ArrayList)simpleJdbcTemplate.query(
               "select id, name, namespace, description, adminobjectid from model where id=" + id, 
               new ModelMapper());
		return modellist;

	}
	public void deleteAllModels(){
		
		logger.info("delete Model Records");
		int count = simpleJdbcTemplate.update("DELETE * FROM model");
       logger.info("Rows affected: " + count);
	}
	public void deleteModel(int id){
		logger.info("delete model, id= " + id);
		int count = simpleJdbcTemplate.update("DELETE * FROM model WHERE ID=" + id);
       logger.info("Rows affected: " + count);
	}
	
	@Transactional(readOnly = true)
	public Model getModel(int id) {
		logger.info("getModel, id= " + id);
		Model md = new Model();
		AdminObject  ao = new AdminObject();
		try {
			md = this.simpleJdbcTemplate.queryForObject(
			"select id, adminobjectid,  description, namespace, name from model where id=?",
			ParameterizedBeanPropertyRowMapper.newInstance(Model.class),id);
		}
		catch (EmptyResultDataAccessException ex) {
			throw new ObjectRetrievalFailureException(Model.class, new Integer(id));
		}
		
		int modelAdminId = md.getAdminid();
		logger.info("Admin Obj, id= " + modelAdminId);
		if(modelAdminId>0){
			try {
				ao = this.simpleJdbcTemplate.queryForObject(
				"select id, registrationstatus, registeredby, comments, createdon, createdby from adminobject where id=?",
				ParameterizedBeanPropertyRowMapper.newInstance(AdminObject.class),modelAdminId);
			}
			catch (EmptyResultDataAccessException ex) {
				throw new ObjectRetrievalFailureException(AdminObject.class, new Integer(modelAdminId));
			}
		}

		
		md = fuseMD(md,ao);
		return md;
	}
	
	private Model fuseMD(Model md, AdminObject ao){
		md.setAdministeredBy(ao.getAdministeredBy());
		md.setAdministrativeStatus(ao.getAdministrativeStatus());
		md.setAdminObjectType(ao.getAdminObjectType());
		md.setClassification(ao.getClassification());
		md.setClassifiedBy(ao.getClassifiedBy());
		md.setComments(ao.getComments());
		md.setCreatedBy(ao.getCreatedBy());
		md.setCreatedOn(ao.getCreatedOn());
		md.setDateFirstActive(ao.getDateFirstActive());
		md.setDateFirstInactive(ao.getDateFirstInactive());
		md.setLastModifiedBy(ao.getLastModifiedBy());
		md.setLastModifiedOn(ao.getLastModifiedOn());
		md.setRegisteredBy(ao.getRegisteredBy());
		md.setRegisteredOn(ao.getRegisteredOn());
		md.setRegistrationStatus(ao.getRegistrationStatus());
		md.setSubmittedby(ao.getSubmittedby());
		return md;
	}
	
	private static class ModelMapper implements ParameterizedRowMapper<Model> {

       public Model mapRow(ResultSet rs, int rowNum) throws SQLException {
    	   final Log logger = LogFactory.getLog(getClass());
    	   Model mobj = new Model();
    	   mobj.setId(rs.getInt("id"));
    	   mobj.setName(rs.getString("name"));
    	   mobj.setNamespace(rs.getString("namespace"));
    	   mobj.setDescription(rs.getString("description"));
    	   mobj.setAdminid(rs.getInt("adminobjectid"));
    	   logger.info("Model : " + mobj.toString());
           return mobj;
       }

	}
	
	
}
