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


import uk.org.datalink.MDR.domain.Relationship;

@Repository
public class JDBCRelationshipDao implements RelationshipDao{
	 /** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	protected DataSource dataSource;
	protected SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dSource) {
		this.dataSource = dSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dSource);
	}

	public ArrayList<Relationship> getRelationshipList(){
		logger.info("Getting Relationship list!");
        ArrayList<Relationship> relationships = (ArrayList) simpleJdbcTemplate.query(
                "select id, classscheme_id, subject_id, obj_id, type_id from relationship", new RelationshipMapper());
        return relationships;
	}
	public void updateRelationship(Relationship rlObj){
		logger.info("Updating Relationship: " + rlObj.getId());
        int count = simpleJdbcTemplate.update(
            "update relationship set classscheme_id = :classscheme_id, subject_id = :subject_id, obj_id = :obj_id, type_id = :type_id where id = :id",
            new MapSqlParameterSource().addValue("classscheme_id", rlObj.getClassscheme_id())
                .addValue("subject_id", rlObj.getSubject_id())
                .addValue("obj_id", rlObj.getObj_id())
                .addValue("type_id", rlObj.getType_id()));
        logger.info("Rows affected: " + count);
	}
	
	public int createRelationship(Relationship rlObj){
		logger.info("create Relationship, createdBy= " + rlObj.getType_id());
		int count = simpleJdbcTemplate.update("INSERT INTO relationship (classscheme_id, subject_id, obj_id, type_id) VALUES(?,?,?,?)",
		new Object[] { rlObj.getClassscheme_id(), rlObj.getSubject_id(), rlObj.getObj_id(), rlObj.getType_id()});
        logger.info("Rows affected: " + count);
        String adminNoSQL = "select last_value from seq_rel;" ;
        TreeMap empty = null;
        int adminNo = simpleJdbcTemplate.queryForInt(adminNoSQL,empty);
        return adminNo;
	}
	
	public List<Relationship> getRelationshipListItem(int id){
		logger.info("get relationshipListItem, id= " + id);
		ArrayList<Relationship> relationshiplist = (ArrayList) simpleJdbcTemplate.query(
                "select id, classscheme_id, subject_id, obj_id, type_id from relationship where id=" + id, 
                new RelationshipMapper());
		return relationshiplist;
	}
	
	public Relationship getRelationship(int id){
		logger.info("get relationship, id= " + id);
		Relationship relationship = (Relationship) simpleJdbcTemplate.query(
                "select id, classscheme_id, subject_id, obj_id, type_id from relationship where id=" + id, 
                new RelationshipMapper());
		return relationship;
	}
	
	public void deleteAllRelationship(){
		logger.info("delete relationshiplist Records");
		int count = simpleJdbcTemplate.update("DELETE * FROM relationship");
        logger.info("Rows affected: " + count);
	}
	public void deleteRelationship(int id){
		logger.info("delete relationship, id= " + id);
		int count = simpleJdbcTemplate.update("DELETE * FROM relationship WHERE ID=" + id);
        logger.info("Rows affected: " + count);
	}
	
	private static class RelationshipMapper implements ParameterizedRowMapper<Relationship> {

        public Relationship mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Relationship rel = new Relationship();
        	rel.setId(rs.getInt("id"));
        	rel.setClassscheme_id(rs.getInt("classscheme_id"));
        	rel.setSubject_id(rs.getInt("subject_id"));
        	rel.setObj_id(rs.getInt("obj_id"));
        	rel.setType_id(rs.getInt("type_id"));
            return rel;
        }

    }
}
