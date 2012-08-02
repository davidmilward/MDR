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
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import uk.org.datalink.MDR.domain.ClassificationSchemeType;


@Repository
public class JDBCClassificationSchemeTypeDao implements ClassificationSchemeTypeDao {

	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    protected DataSource dataSource;
	protected SimpleJdbcTemplate simpleJdbcTemplate;
	
   @Autowired
	public void setDataSource(DataSource dSource) {
		this.dataSource = dSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dSource);
	}

	
	public ArrayList<ClassificationSchemeType> getClassificationSchemeTypeList(){
		logger.info("Getting ClassificationSchemeType list!");
        ArrayList<ClassificationSchemeType> cslist = (ArrayList) simpleJdbcTemplate.query(
                "select id, typename, description, url from ClassificationSchemeType", new ClassificationSchemeTypeMapper());
        return cslist;
       
	}
	public void updateClassificationSchemeType(ClassificationSchemeType cstObj){
		logger.info("Updating ClassificationSchemeType: " );
        int count = simpleJdbcTemplate.update(
            "update classificationscheme set description = :description, url = :url, typename = :typename " +
            " where id = :id",
            new MapSqlParameterSource().addValue("id", cstObj.getId())
                .addValue("description", cstObj.getDescription())
                .addValue("url", cstObj.getUrl())
                .addValue("typename", cstObj.getTypename()));
        logger.info("Rows affected: " + count);
	}
	public void saveClassificationSchemeType(ClassificationSchemeType csObj){
		logger.info("saveClassificationSchemeType");
		int count = simpleJdbcTemplate.update("INSERT INTO classificationscheme (typename, url, description) VALUES(?,?,?)",
		new Object[] { csObj.getTypename(),csObj.getUrl(), csObj.getDescription()});
        logger.info("Rows affected: " + count);
	}
	public int createClassificationSchemeType(ClassificationSchemeType csObj){
		logger.info("createClassificationSchemeType");
		int count = simpleJdbcTemplate.update("INSERT INTO classificationscheme (typename, url, description) VALUES(?,?,?)",
		new Object[] { csObj.getTypename(),csObj.getUrl(),csObj.getDescription()});
        logger.info("Rows affected: " + count);
        String addNoSQL = "select last_value from seq_cst;" ;
        TreeMap empty = null;
        int addNo = simpleJdbcTemplate.queryForInt(addNoSQL,empty);
        return addNo;
	}
	public List<ClassificationSchemeType> getClassificationSchemeType(int id){
		logger.info("get classificationScheme, id= " + id);
		ArrayList<ClassificationSchemeType> cslist = (ArrayList) simpleJdbcTemplate.query(
                "select id, typename, url, description  from classificationSchemeType where id=" + id, 
                new ClassificationSchemeTypeMapper());
		return cslist;
	}
	public void deleteAllClassificationSchemeTypes(){
		logger.info("delete ClassificationScheme Records");
		int count = simpleJdbcTemplate.update("DELETE * FROM classificationSchemeType");
        logger.info("Rows affected: " + count);
	}
	public void deleteClassificationSchemeType(int id){
		logger.info("delete ClassificationScheme, id= " + id);
		int count = simpleJdbcTemplate.update("DELETE * FROM classificationSchemeType WHERE ID=" + id);
        logger.info("Rows affected: " + count);
	}
	
	private static class ClassificationSchemeTypeMapper implements ParameterizedRowMapper<ClassificationSchemeType> {

        public ClassificationSchemeType mapRow(ResultSet rs, int rowNum) throws SQLException {
        	ClassificationSchemeType cstObj = new ClassificationSchemeType();
        	cstObj.setId(rs.getInt("id"));
        	cstObj.setTypename(rs.getString("typename"));
        	cstObj.setUrl(rs.getString("url"));
        	cstObj.setDescription(rs.getString("description"));
            return cstObj;
        }
    }

}

	
