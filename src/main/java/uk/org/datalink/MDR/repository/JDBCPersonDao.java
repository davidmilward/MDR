package uk.org.datalink.MDR.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.*;

import uk.org.datalink.MDR.domain.Person;


@Repository
public class JDBCPersonDao implements PersonDao{

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private SimpleJdbcTemplate simpleJdbcTemplate;

	private SimpleJdbcInsert insertPerson;

	private final List<uk.org.datalink.MDR.domain.Person> people = new ArrayList<uk.org.datalink.MDR.domain.Person>();
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);

	}
	
	/**
	 * Refresh the cache of People.
	 * possible not needed - just to test
	 */
	@ManagedOperation
	@Transactional(readOnly = true)
	public void refreshPersonCache() throws DataAccessException {
		synchronized (this.people) {
			this.logger.info("Refreshing people cache");
  
			// Retrieve the list of all people.
			this.people.clear();
			this.people.addAll(this.simpleJdbcTemplate.query(
					"SELECT id, title, firstname, surname, othernames, alias, dob FROM person ORDER BY lastname,firstname",
					ParameterizedBeanPropertyRowMapper.newInstance(uk.org.datalink.MDR.domain.Person.class)));

		}
	}
	
	@Transactional(readOnly = true)
	public Collection<uk.org.datalink.MDR.domain.Person> getPeople() throws DataAccessException {
		synchronized (this.people) {
			if (this.people.isEmpty()) {
				refreshPersonCache();
			}
			return this.people;
		}
	}
    
	/**
	 * Loads the {@link Person} with the supplied <code>id</code>; 
	 */
	@Transactional(readOnly = true)
	public uk.org.datalink.MDR.domain.Person getPerson(int id) throws DataAccessException {
		uk.org.datalink.MDR.domain.Person person;
		try {
			person = this.simpleJdbcTemplate.queryForObject(
					"SELECT id, title, firstname, surname, othernames, alias, dob, notes FROM person WHERE id=?",
					ParameterizedBeanPropertyRowMapper.newInstance(Person.class),
					id);
		}
		catch (EmptyResultDataAccessException ex) {
			throw new ObjectRetrievalFailureException(Person.class, new Integer(id));
		}
		return person;
	}
	
	
	public ArrayList<uk.org.datalink.MDR.domain.Person> getPeopleList(){
	    logger.info("Getting getPeopleList!");
        ArrayList<uk.org.datalink.MDR.domain.Person> objects = (ArrayList)this.simpleJdbcTemplate.query(
                "select id, title, firstname, surname, othernames, alias, dob, notes from person", 
                new PersonMapper());
        return objects;
	}
	
	
	
	public void updatePerson(uk.org.datalink.MDR.domain.Person psnObj){
		logger.info("Updating Person: " + psnObj.getDob());
        int count = this.simpleJdbcTemplate.update(
            "update person set title = :title, firstname = :firstname, surname = :surname, " +
            "othernames = :othernames, alias = :alias, dob = :dob, notes = :notes where id = :id",
            new MapSqlParameterSource().addValue("title", psnObj.getTitle())
                .addValue("firstname", psnObj.getFirstname())
                .addValue("surname", psnObj.getSurname())
                .addValue("othernames", psnObj.getOtherNames())
                .addValue("alias", psnObj.getAlias())
                .addValue("dob", psnObj.getDob())
                .addValue("id",  psnObj.getId())
                .addValue("notes", psnObj.getNotes()));
        logger.info("Rows affected: " + count);
	}
	
	public int createPerson(uk.org.datalink.MDR.domain.Person psnObj){
		logger.info("createPerson, createdBy= " + psnObj.toString());
		String title = psnObj.getTitle();
		if(title.length()>5){
			logger.info("title length= " + title.length());
			title = title.substring(0, 4);
		}
		//JdbcTemplate insert = getJdbcTemplate();
		int count = this.simpleJdbcTemplate.update("INSERT INTO person (title, firstname, surname, othernames, alias, dob, " +
				" notes) VALUES(?,?,?,?,?,?,?)",
		new Object[] { title, psnObj.getFirstname(),psnObj.getSurname(), psnObj.getOtherNames(),
				psnObj.getAlias(), psnObj.getDob(),  psnObj.getNotes()});
        logger.info("Rows affected: " + count);
        String perNoSQL = "select last_value from seq_psn;" ;
        TreeMap empty = null;
        int perNo = this.simpleJdbcTemplate.queryForInt(perNoSQL,empty);
        return perNo;
	}
	
	public List<uk.org.datalink.MDR.domain.Person> getPersonList(int id){
		logger.info("get Person, id= " + id);
		//JdbcTemplate insert = getJdbcTemplate();
		ArrayList<uk.org.datalink.MDR.domain.Person> personlist = (ArrayList) this.simpleJdbcTemplate.query(
                "select id, title, firstname, surname, othernames, alias," +
                " dob, notes from person where id=" + id, 
                new PersonMapper());
		return personlist;
	}
	public void deleteAllPersons(){
		logger.info("delete Person Records");
		//JdbcTemplate insert = this.simpleJdbcTemplate.;
		int count = this.simpleJdbcTemplate.update("DELETE * FROM person");
        logger.info("Rows affected: " + count);
	}
	public void deletePerson(int id){
		logger.info("delete person, id= " + id);
		//JdbcTemplate insert = getJdbcTemplate();
		int count = this.simpleJdbcTemplate.update("DELETE * FROM person WHERE ID=" + id);
        logger.info("Rows affected: " + count);
	}
	
	 private static class PersonMapper implements ParameterizedRowMapper<Person> {

	        public uk.org.datalink.MDR.domain.Person mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	uk.org.datalink.MDR.domain.Person person = new Person();
	        	person.setId(rs.getInt("id"));
	        	person.setAlias(rs.getString("alias"));
	        	person.setDob(rs.getDate("dob"));
	        	person.setFirstname(rs.getString("firstname"));
	        	person.setSurname(rs.getString("surname"));
	        	person.setNotes(rs.getString("notes"));
	        	person.setOtherNames(rs.getString("othernames"));
	        	person.setTitle(rs.getString("title"));
	            return person;
	        }
	    }
	
	
	
}
