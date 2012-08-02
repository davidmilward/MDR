package uk.org.datalink.MDR.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;


import uk.org.datalink.MDR.domain.Organisation;


public class JDBCOrganisationDao extends SimpleJdbcDaoSupport implements OrganisationDao{
	
	 /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	
	public ArrayList<Organisation> getOrganisationList(){
	
		logger.info("Getting Organisations!");
        ArrayList<Organisation> objects = (ArrayList) getSimpleJdbcTemplate().query(
                "select id, name, description, contactid, organisationemail from organisation", 
                new OrganisationMapper());
        return objects;
	}
	public void updateOrganisation(Organisation orgObj){
		logger.info("Updating Organisation: " + orgObj.getName());
        int count = getSimpleJdbcTemplate().update(
            "update organisation set name = :name, description = :description, contactid = :contactid, organisationemail =:organisationemail  where id = :id",
            new MapSqlParameterSource().addValue("name", orgObj.getName())
                .addValue("description", orgObj.getDescription())
                .addValue("contactid", orgObj.getContactid())
                .addValue("email", orgObj.getOrganisationemail()));
        logger.info("Rows affected: " + count);
	}
	public int createOrganisation(Organisation orgObj){
		
		logger.info("Organisation, " + orgObj.getDescription());
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("INSERT INTO ORGANISATION (name, description, contactid, organisationemail) VALUES(?,?,?,?)",
		new Object[] { orgObj.getName(), orgObj.getDescription(), orgObj.getContactid(), orgObj.getOrganisationemail() });
        logger.info("Rows affected: " + count);
        String orgNoSQL = "select last_value from seq_org" ;
        int orgNo = insert.queryForInt(orgNoSQL,null);
        return orgNo;
		
	}
	public List<Organisation> getOrganisation(int id){
		
		logger.info("getOrganisation, id= " + id);
		JdbcTemplate insert = getJdbcTemplate();
		ArrayList<Organisation> objects = (ArrayList) getSimpleJdbcTemplate().query(
                "select id, name, description, contactid, organisationemail from organisation where id=" + id, 
                new OrganisationMapper());
		return objects;
	}
	public void deleteAllOrganisations(){
		logger.info("deleteAllOrganisationObjects");
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("DELETE * FROM organisation");
        logger.info("Rows affected: " + count);
	}
	public void deleteOrganisation(int id){
		logger.info("delete OrganisationObjects, id= " + id);
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("DELETE * FROM organisation WHERE ID=" + id);
        logger.info("Rows affected: " + count);
	}
	
	private static class OrganisationMapper implements ParameterizedRowMapper<Organisation> {

        public Organisation mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Organisation orgObj = new Organisation();
        	orgObj.setId(rs.getInt("id"));
        	orgObj.setContactid(rs.getInt("contactid"));
        	orgObj.setDescription(rs.getString("description")); 
        	orgObj.setName(rs.getString("name"));
        	orgObj.setOrganisationemail(rs.getString("organisationemail"));
            return orgObj;
        }
    }

}
