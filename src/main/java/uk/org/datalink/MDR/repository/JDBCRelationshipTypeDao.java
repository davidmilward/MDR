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

import uk.org.datalink.MDR.domain.RelationshipType;

@Repository
public class JDBCRelationshipTypeDao implements RelationshipTypeDao{

	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	protected DataSource dataSource;
	protected SimpleJdbcTemplate simpleJdbcTemplate;
	
   @Autowired
	public void setDataSource(DataSource dSource) {
		this.dataSource = dSource;
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dSource);
	}
	public ArrayList<RelationshipType> getRelationshipTypeList(){
		logger.info("Getting RelationshipType list!");
        ArrayList<RelationshipType> relationshiptypes = (ArrayList) simpleJdbcTemplate.query(
                "select id, name, description from relationshiptype", new RelationshipTypeMapper());
        return relationshiptypes;
	}
	public void updateRelationshipType(RelationshipType rlObj){
		logger.info("Updating RelationshipType: " + rlObj.getId());
        int count = simpleJdbcTemplate.update(
            "update relationshiptype set name = :name, description = :description where id = :id",
            new MapSqlParameterSource().addValue("name", rlObj.getName())
                .addValue("description", rlObj.getDescription()));
        logger.info("Rows affected: " + count);
	}
	
	public int createRelationshipType(RelationshipType rlObj){
		logger.info("create RelationshipType, createdBy= " + rlObj.getName());
		int count = simpleJdbcTemplate.update("INSERT INTO relationshiptype (name, description) VALUES(?,?)",
		new Object[] { rlObj.getName(), rlObj.getDescription()});
        logger.info("Rows affected: " + count);
        String adminNoSQL = "select last_value from seq_rlt;" ;
        TreeMap empty = null;
        int adminNo = simpleJdbcTemplate.queryForInt(adminNoSQL,empty);
        return adminNo;
	}
	
	public List<RelationshipType> getRelationshipType(int id){
		logger.info("get relationshiptype, id= " + id);
		ArrayList<RelationshipType> relationshiptypelist = (ArrayList) simpleJdbcTemplate.query(
                "select id, name, description from relationshiptype where id=" + id, 
                new RelationshipTypeMapper());
		return relationshiptypelist;
	}
	
	public void deleteAllRelationshipTypes(){
		logger.info("delete relationshiptypelist Records");
		int count = simpleJdbcTemplate.update("DELETE * FROM relationshiptype");
        logger.info("Rows affected: " + count);
	}
	public void deleteRelationshipType(int id){
		logger.info("delete relationshiptype, id= " + id);
		int count = simpleJdbcTemplate.update("DELETE * FROM relationshiptype WHERE ID=" + id);
        logger.info("Rows affected: " + count);
	}
	
	private static class RelationshipTypeMapper implements ParameterizedRowMapper<RelationshipType> {

        public RelationshipType mapRow(ResultSet rs, int rowNum) throws SQLException {
        	RelationshipType rel = new RelationshipType();
        	rel.setId(rs.getInt("id"));
        	rel.setName(rs.getString("name"));
        	rel.setDescription(rs.getString("description"));
            return rel;
        }

    }

}
