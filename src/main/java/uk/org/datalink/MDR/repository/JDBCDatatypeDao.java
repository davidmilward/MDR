package uk.org.datalink.MDR.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import uk.org.datalink.MDR.domain.Datatype;
import uk.org.datalink.MDR.domain.ValueDomain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SuppressWarnings("deprecation")
@Repository
public class JDBCDatatypeDao implements DatatypeDao {
	
	private static class DatatypeMapper implements ParameterizedRowMapper<Datatype> {

        public Datatype mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Datatype dt = new Datatype();
        	dt.setId(rs.getInt("id"));
        	dt.setIdentifier(rs.getString("identifier"));
        	dt.setDescription(rs.getString("description"));
        	dt.setScheme(rs.getString("scheme"));
        	dt.setDataTypeName(rs.getString("datatypename"));
            return dt;
        }
    }
	
	 /** Logger for this class and subclasses */
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private SimpleJdbcTemplate simpleJdbcTemplate;
	protected DataSource dataSource;

	@Autowired
	public JDBCDatatypeDao(DataSource dSource){
		this.dataSource = dSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	@Override
	public ArrayList<Datatype> getDatatypeList() {
		 logger.info("Getting Datatype!");
	        @SuppressWarnings({ "unchecked", "deprecation" })
			ArrayList<Datatype> objects = (ArrayList<Datatype>) this.simpleJdbcTemplate.query(
	                "Select id, description, identifier, scheme, datatypename from datatype", 
	                new DatatypeMapper());
	        return objects;
	}

	@Override
	public void updateDatatype(Datatype dtObj) {
		
		 logger.info("Saving Datatype : " + dtObj.getDataTypeName());

	     @SuppressWarnings("deprecation")
		int count = this.simpleJdbcTemplate.update(
	            "update datatype set " +
	            "description = :description, " +
	            "identifier = :identifier, " +
	            "scheme = :scheme, " +
	            "datatypename = :datatypename, " +
	            "where id = :id",
	            new MapSqlParameterSource().addValue("description", dtObj.getDescription())
	            	.addValue("description", dtObj.getDescription())
	                .addValue("identifier", dtObj.getIdentifier())
	                .addValue("scheme", dtObj.getScheme())
	                .addValue("datatypename", dtObj.getDataTypeName())
	                .addValue("id", dtObj.getId()));

	      logger.info("Datatype: Rows affected: " + count);
	}

	
	@Override
	public int createDatatype(Datatype dtObj) {
		logger.info("create Datatype, createdBy= " + dtObj.getDescription());

		@SuppressWarnings("deprecation")
		int count = this.simpleJdbcTemplate.update("INSERT INTO datatype (description, identifier, scheme, datatypename) VALUES(?,?,?,?)",
		new Object[] { dtObj.getDescription(), dtObj.getIdentifier(),dtObj.getScheme(), dtObj.getDataTypeName()});
        logger.info("createDatatype:Rows affected: " + count);
        String dttNoSQL = "select last_value from seq_dtt;" ;
        TreeMap empty = null;
        @SuppressWarnings({ "deprecation", "unchecked" })
		int dttNo = this.simpleJdbcTemplate.queryForInt(dttNoSQL,empty);
        logger.info("****New Datatype registered - ref: " + dttNo + "****");
        return dttNo;
	}


	@Override
	public Datatype getDatatype(int id) {
		logger.info("get Datatype, id= " + id);
		Datatype dt = this.simpleJdbcTemplate.queryForObject(
                "select id, description, identifier, scheme, datatypename from datatype where id=?" , 
                ParameterizedBeanPropertyRowMapper.newInstance(Datatype.class),id);
		return dt;
	}

	@Override
	public void deleteAllDatatypes() {
		logger.info("delete Datatype Records");
		int count = this.simpleJdbcTemplate.update("DELETE * FROM datatype");
        logger.info("Datatype-Rows affected: " + count);
		
	}

	@Override
	public void deleteDatatype(int id) {
		logger.info("delete Datatype, id= " + id);
		int count = this.simpleJdbcTemplate.update("DELETE * FROM datatype WHERE id=" + id);
        logger.info("Datatype-Rows affected: " + count);
		
		
	}

	
	
	
	
	
}
