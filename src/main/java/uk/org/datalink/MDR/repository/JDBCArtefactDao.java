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

import uk.org.datalink.MDR.domain.Artefact;



@Repository
public class JDBCArtefactDao implements ArtefactDao{

	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	private SimpleJdbcTemplate simpleJdbcTemplate;


    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	public ArrayList<Artefact> getArtefactList(){
		logger.info("Getting Artefact list!");
        ArrayList<Artefact> artefactlist = (ArrayList) simpleJdbcTemplate.query(
                "select id, modelid, refid, url, notes from artefact", new ArtefactMapper());
        return artefactlist;
       
	}
	public void updateArtefact(Artefact addObj){
		logger.info("Updating artefact: " + addObj.getId());
        int count = simpleJdbcTemplate.update(
            "update artefact set modelid = :modelid, refid = :refid, url = :url, notes = :notes, " +
            " where id = :id",
            new MapSqlParameterSource().addValue("modelid", addObj.getModelid())
                .addValue("refid", addObj.getExternalid())
                .addValue("url", addObj.getArtefacturl())
                .addValue("notes", addObj.getNotes())
                .addValue("id", addObj.getId()));
        logger.info("Rows affected: " + count);
	}
	public void saveArtefact(Artefact artObj){
		logger.info("createArtefact, createdBy= " + artObj.getExternalid());
		int count = simpleJdbcTemplate.update("INSERT INTO artefact (refid,url,notes,modelid) VALUES(?,?,?,?)",
		new Object[] { artObj.getExternalid(), artObj.getArtefacturl(), artObj.getNotes(), artObj.getModelid()});
        logger.info("Rows affected: " + count);
	}
	public int createArtefact(Artefact artObj){
		logger.info("createArtefact, createdBy= " + artObj.getNotes());
		int count = simpleJdbcTemplate.update("INSERT INTO artefact (refid,url,notes,modelid) VALUES(?,?,?,?)",
		new Object[] { artObj.getExternalid(), artObj.getArtefacturl(), artObj.getNotes(), artObj.getModelid()});
        logger.info("Rows affected: " + count);
        String addNoSQL = "select last_value from seq_art;" ;
        TreeMap empty = null;
        int addNo = simpleJdbcTemplate.queryForInt(addNoSQL,empty);
        return addNo;
	}
	public List<Artefact> getArtefactList(int id){
		logger.info("get ArtefactList, id= " + id);
		ArrayList<Artefact> artefactlist = (ArrayList) simpleJdbcTemplate.query(
                "select id, refid, url,modelid,notes from artefact where id=" + id, 
                new ArtefactMapper());
		return artefactlist;
	}
	public Artefact getArtefact(int id){
		logger.info("get Artefact, id= " + id);
		Artefact artefact = (Artefact) simpleJdbcTemplate.query(
                "select id, refid, url,modelid,notes from artefact where id=" + id, 
                new ArtefactMapper());
		return artefact;
	}
	public void deleteAllArtefacts(){
		logger.info("delete Artefact Records");
		int count = simpleJdbcTemplate.update("DELETE * FROM artefact");
        logger.info("Rows affected: " + count);
	}
	public void deleteArtefact(int id){
		logger.info("delete artefact, id= " + id);
		int count = simpleJdbcTemplate.update("DELETE * FROM artefact WHERE ID=" + id);
        logger.info("Rows affected: " + count);
	}
	
	private static class ArtefactMapper implements ParameterizedRowMapper<Artefact> {

        public Artefact mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Artefact obj = new Artefact();
            obj.setId(rs.getInt("id"));
            obj.setModelid(rs.getInt("modelid"));
            obj.setArtefacturl(rs.getString("url"));
            obj.setExternalid(rs.getInt("refid"));
            obj.setNotes(rs.getString("notes"));
            return obj;
        }

    }

	
	
	
	
}
