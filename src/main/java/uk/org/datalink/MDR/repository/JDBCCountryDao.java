package uk.org.datalink.MDR.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import uk.org.datalink.MDR.domain.AdminObject;
import uk.org.datalink.MDR.domain.Country;



    public class JDBCCountryDao extends SimpleJdbcDaoSupport implements CountryDao {
	
	 /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

	public ArrayList<Country> getCountryList(){
		logger.info("Getting country list!");
        ArrayList<Country> countries = (ArrayList) getSimpleJdbcTemplate().query(
                "select id, abbr2, abbr3, name from country", new CountryMapper());
        return countries;
	}
 
	public void updateCountry(Country cntObj){
		logger.info("Updating country: " + cntObj.getId());
        int count = getSimpleJdbcTemplate().update(
            "update country set abbr3 = :abbr3, abbr2 = :abbr2, name=name where id = :id",
            new MapSqlParameterSource().addValue("abbr2", cntObj.getAbbr2())
                .addValue("abbr3", cntObj.getAbbr3())
                .addValue("name", cntObj.getName())
                .addValue("id", cntObj.getId()));
        logger.info("Rows affected: " + count);
	}

	public void saveCountry(Country cntObj){
		
		logger.info("createCountry, createdBy= " + cntObj.getAbbr3());
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("INSERT INTO country (abbr2,abbr3,name) VALUES(?,?,?)",
		new Object[] { cntObj.getAbbr2(), cntObj.getAbbr3(), cntObj.getName()});
        logger.info("Rows affected: " + count);
	}
	public int createCountry(Country cntObj){
		
		logger.info("createCountry, createdBy= " + cntObj.getAbbr3());
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("INSERT INTO country (abbr2,abbr3,name) VALUES(?,?,?)",
		new Object[] { cntObj.getAbbr2(), cntObj.getAbbr3(), cntObj.getName()});
        logger.info("Rows affected: " + count);
        String adminNoSQL = "select last_value from seq_cnt;" ;
        int adminNo = insert.queryForInt(adminNoSQL,null);
        return adminNo;
	
	}
	public List<Country> getCountry(int id){
		
		logger.info("get country, id= " + id);
		JdbcTemplate insert = getJdbcTemplate();
		ArrayList<Country> countrylist = (ArrayList) getSimpleJdbcTemplate().query(
                "select id, abbr2, abbr3, name from country where id=" + id, 
                new CountryMapper());
		return countrylist;

	}
	public void deleteAllCountry(){
		
		logger.info("delete Country Records");
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("DELETE * FROM country");
        logger.info("Rows affected: " + count);
	}
	public void deleteCountry(int id){
		logger.info("delete country, id= " + id);
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("DELETE * FROM country WHERE ID=" + id);
        logger.info("Rows affected: " + count);
	}
	
	private static class CountryMapper implements ParameterizedRowMapper<Country> {

        public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Country obj = new Country();
            obj.setId(rs.getInt("id"));
            obj.setName(rs.getString("name"));
            obj.setAbbr2(rs.getString("abbr2"));
            obj.setAbbr3(rs.getString("abbr3"));
            return obj;
        }

    }
	
	
	
	
}
