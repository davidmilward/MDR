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

import uk.org.datalink.MDR.domain.ClassificationScheme;



@Repository
public class JDBCClassificationSchemeDao implements ClassificationSchemeDao {

	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	protected DataSource dataSource;
	protected SimpleJdbcTemplate simpleJdbcTemplate;
	
   @Autowired
	public void setDataSource(DataSource dSource) {
		this.dataSource = dSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dSource);
	}

	
	public ArrayList<ClassificationScheme> getClassificationSchemeList(){
		logger.info("Getting Artefact list!");
        ArrayList<ClassificationScheme> cslist = (ArrayList) simpleJdbcTemplate.query(
                "select id, schemetype, description from ClassificationScheme", new ClassificationSchemeMapper());
        return cslist;
       
	}
	public void updateClassificationScheme(ClassificationScheme csObj){
		logger.info("Updating ClassificationScheme: " + csObj.getId());
        int count = simpleJdbcTemplate.update(
            "update classificationscheme set description = :description, schemetype = :schemetype " +
            " where id = :id",
            new MapSqlParameterSource().addValue("id", csObj.getId())
                .addValue("description", csObj.getDescription())
                .addValue("schemetype", csObj.getSchemeType()));
        logger.info("Rows affected: " + count);
	}
	public void saveClassificationScheme(ClassificationScheme csObj){
		logger.info("saveArtefact");
		int count = simpleJdbcTemplate.update("INSERT INTO classificationscheme (schemetype, description) VALUES(?,?)",
		new Object[] { csObj.getSchemeType(),csObj.getDescription()});
        logger.info("Rows affected: " + count);
	}
	public int createClassificationScheme(ClassificationScheme csObj){
		logger.info("createArtefact");
		int count = simpleJdbcTemplate.update("INSERT INTO classificationscheme (schemetype, description) VALUES(?,?)",
		new Object[] { csObj.getSchemeType(),csObj.getDescription()});
        logger.info("Rows affected: " + count);
        String addNoSQL = "select last_value from seq_cls;" ;
        TreeMap empty = null;
        int addNo = simpleJdbcTemplate.queryForInt(addNoSQL,empty);
        return addNo;
	}
	public ClassificationScheme getClassificationScheme(int id){
		logger.info("get getClassificationSchemeListItem, id= " + id);
		ClassificationScheme cs = (ClassificationScheme) simpleJdbcTemplate.query(
                "select id, url, description  from classificationScheme where id=" + id, 
                new ClassificationSchemeMapper());
		return cs;
	}
	public  List<ClassificationScheme> getClassificationSchemeListItem(int id){
		logger.info("get classificationScheme, id= " + id);
		ArrayList<ClassificationScheme> cslist = (ArrayList) simpleJdbcTemplate.query(
                "select id, url, description  from classificationScheme where id=" + id, 
                new ClassificationSchemeMapper());
		return cslist;
	}
	public void deleteAllClassificationScheme(){
		logger.info("delete ClassificationScheme Records");
		int count = simpleJdbcTemplate.update("DELETE * FROM classificationScheme");
        logger.info("Rows affected: " + count);
	}
	public void deleteClassificationScheme(int id){
		logger.info("delete ClassificationScheme, id= " + id);
		int count = simpleJdbcTemplate.update("DELETE * FROM classificationScheme WHERE ID=" + id);
        logger.info("Rows affected: " + count);
	}
	
	private static class ClassificationSchemeMapper implements ParameterizedRowMapper<ClassificationScheme> {

        public ClassificationScheme mapRow(ResultSet rs, int rowNum) throws SQLException {
        	ClassificationScheme obj = new ClassificationScheme();
            obj.setId(rs.getInt("id"));
            obj.setDescription(rs.getString("description"));
            return obj;
        }

    }




	
	
}
