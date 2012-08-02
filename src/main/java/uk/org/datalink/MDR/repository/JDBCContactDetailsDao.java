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

import uk.org.datalink.MDR.domain.ContactDetails;



public class JDBCContactDetailsDao extends SimpleJdbcDaoSupport implements ContactDetailsDao {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

	

	public ArrayList<ContactDetails> getContactDetailsList(){
		logger.info("Getting ContactDetails list!");
        ArrayList<ContactDetails> ContactDetailslist = (ArrayList) getSimpleJdbcTemplate().query(
                "select id, pid, tel, email from contactdetails", new ContactDetailsMapper());
        return ContactDetailslist;
	}
	
	public void updateContactDetails(ContactDetails cntObj){
		logger.info("Updating ContactDetails: " + cntObj.getId());
        int count = getSimpleJdbcTemplate().update(
            "update contactdetails set pid = :pid, tel = :tel, email = :email where id = :id",
            new MapSqlParameterSource().addValue("pid", cntObj.getPid())
                .addValue("tel", cntObj.getTelephone())
                .addValue("email", cntObj.getEmail())
                .addValue("id", cntObj.getId()));
        logger.info("Rows affected: " + count);
	}
	

	public int createContactDetails(ContactDetails cntObj){
		logger.info("create ContactDetails, createdBy= " + cntObj.getEmail());
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("INSERT INTO contactdetails (pid,tel,email) VALUES(?,?,?)",
		new Object[] { cntObj.getPid(), cntObj.getTelephone(), cntObj.getEmail()});
        logger.info("Rows affected: " + count);
        String conNoSQL = "select last_value from seq_con;" ;
        int conNo = insert.queryForInt(conNoSQL,null);
        return conNo;
	}
	
	public List<ContactDetails> getContactDetails(int id){
		
		logger.info("get Address, id= " + id);
		JdbcTemplate insert = getJdbcTemplate();
		ArrayList<ContactDetails> contactDetailslist = (ArrayList) getSimpleJdbcTemplate().query(
                "select id, pid, tel, email from contactdetails where id=" + id, 
                new ContactDetailsMapper());
		return contactDetailslist;
	}
	
	public void deleteAllContactDetails(){
		logger.info("delete All ContactDetails, id= ");
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("DELETE * FROM contactdetails");
        logger.info("Rows affected: " + count);
	}
	
	public void deleteContactDetails(int id){
		logger.info("delete ContactDetails, id= " + id);
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("DELETE * FROM contactdetails WHERE ID=" + id);
        logger.info("Rows affected: " + count);
	}
	
	private static class ContactDetailsMapper implements ParameterizedRowMapper<ContactDetails> {

        public ContactDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        	ContactDetails obj = new ContactDetails();
            obj.setId(rs.getInt("id"));
            obj.setPid(rs.getInt("pid"));
            obj.setTelephone(rs.getString("tel"));
            obj.setEmail(rs.getString("email"));
            return obj;
        }

    }
}
