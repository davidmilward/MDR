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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;


import uk.org.datalink.MDR.domain.Datatype;
import uk.org.datalink.MDR.domain.UnitsOfMeasure;

public class JDBCUnitOfMeasureDao implements UnitOfMeasureDao {
	
	 /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private SimpleJdbcTemplate simpleJdbcTemplate;
    protected DataSource dataSource;

	@Autowired
	public JDBCUnitOfMeasureDao(DataSource dSource){
		this.dataSource = dSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	} 

    public ArrayList<UnitsOfMeasure> getUnitsOfMeasureList(){	
    	logger.info("Getting UnitsOfMeasure!");
        ArrayList<UnitsOfMeasure> objects = (ArrayList) this.simpleJdbcTemplate.query(
                "select id, name, description, dimensionid from unitsofmeasure", 
                new UnitsOfMeasureMapper());
        return objects;
	}
    
	@SuppressWarnings("deprecation")
	public void updateUnitsOfMeasure(UnitsOfMeasure uomObj){
		logger.info("Updating UnitsOfMeasure: " + uomObj.getId());
        int count = this.simpleJdbcTemplate.update(
            "update unitsofmeasure set name = :name, description = :description, dimensionid = :dimensionid where id = :id",
            new MapSqlParameterSource().addValue("name", uomObj.getName())
                .addValue("description", uomObj.getDescription())
                .addValue("dimensionid", uomObj.getDimension()));
        logger.info("Rows affected: " + count);
	}
	
	public UnitsOfMeasure getUnitsOfMeasure(int id) {
		logger.info("get UnitsOfMeasure, id= " + id);
		@SuppressWarnings("deprecation")
		UnitsOfMeasure umt =  this.simpleJdbcTemplate.queryForObject(
                "select id, name, description, dimensionid from unitsofmeasure where id=?" , 
                ParameterizedBeanPropertyRowMapper.newInstance(UnitsOfMeasure.class),id);
		return umt;
	
	}

	
	@SuppressWarnings("deprecation")
	public int createUnitsOfMeasure(UnitsOfMeasure uomObj){
		logger.info("create UnitsOfMeasure, name= " + uomObj.getName());
		int count = this.simpleJdbcTemplate.update("INSERT INTO unitsofmeasure (name, description, dimensionid) VALUES(?,?,?)",
		new Object[] { uomObj.getName(), uomObj.getDescription(),uomObj.getDimension()});
        logger.info("Rows affected: " + count);
        String uomNoSQL = "select last_value from seq_uom;" ;
        TreeMap<String,String> empty = null;
        int uomNo = this.simpleJdbcTemplate.queryForInt(uomNoSQL,empty);
        return uomNo;
	}
	
	public List<UnitsOfMeasure> getUnitsOfMeasureList(int id){
		logger.info("get UnitsOfMeasure, id= " + id);
		@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
		ArrayList<UnitsOfMeasure> unitsOfMeasurelist = (ArrayList) this.simpleJdbcTemplate.query(
                "select id, name, description, dimensionid from unitsofmeasure where id=" + id, 
                new UnitsOfMeasureMapper());
		return unitsOfMeasurelist;
	}
	
	public void deleteAllUnitsOfMeasures(){
		logger.info("delete UnitsOfMeasure Records");
		int count = this.simpleJdbcTemplate.update("DELETE * FROM unitsofmeasure");
        logger.info("Rows affected: " + count);
	}
	
	public void deleteUnitsOfMeasure(int id){
		logger.info("delete unitsOfMeasure, id= " + id);
		int count = this.simpleJdbcTemplate.update("DELETE * FROM unitsofmeasure WHERE ID=" + id);
        logger.info("Rows affected: " + count);
	}
	private static class UnitsOfMeasureMapper implements ParameterizedRowMapper<UnitsOfMeasure> {

        public UnitsOfMeasure mapRow(ResultSet rs, int rowNum) throws SQLException {
        	UnitsOfMeasure uom = new UnitsOfMeasure();
        	uom.setId(rs.getInt("id"));
        	uom.setDescription(rs.getString("description"));
        	uom.setDimension(rs.getInt("dimension"));
        	uom.setName(rs.getString("name"));
            return uom;
        }
    }
}
