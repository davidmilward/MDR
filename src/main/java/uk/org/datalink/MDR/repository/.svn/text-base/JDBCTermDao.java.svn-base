package uk.org.datalink.MDR.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;

import uk.org.datalink.MDR.domain.DataElement;
import uk.org.datalink.MDR.domain.Term;

@Repository
public class JDBCTermDao  implements TermDao{
	
	 /** Logger for this class and subclasses */
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private SimpleJdbcTemplate simpleJdbcTemplate;


    @Autowired
	public void setDataSource(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	public ArrayList<Term> getTermList() {
        logger.info("Getting Terms!");
        ArrayList<Term> objects = (ArrayList) this.simpleJdbcTemplate.query(
                "SELECT id,term,description from term", 
                new TermMapper());
        return objects;
    }	
    
    private static class TermMapper implements ParameterizedRowMapper<Term> {

        public Term mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Term term = new Term();
        	term.setId(rs.getInt("id"));
        	term.setTerm(rs.getString("term"));
        	term.setDescription(rs.getString("description")); 
            return term;
        }
    }
	
	public void updateTerm(Term termObj){

        logger.info("Saving term : " + termObj.getTerm());
        int count = this.simpleJdbcTemplate.update(
            "update term set " +
            "term = :term, " +
            "description = :description, " +
            "where id = :id",
            new MapSqlParameterSource().addValue("term", termObj.getTerm())
                .addValue("description", termObj.getDescription())
                .addValue("id", termObj.getId()));
        logger.info("Rows affected: " + count);
	}
	
	public int createTerm(Term termObj){
		logger.info("create Term, createdBy= " + termObj.getTerm());

		int count = this.simpleJdbcTemplate.update("INSERT INTO term (term,description) VALUES(?,?)",
		new Object[] { termObj.getTerm(), termObj.getDescription()});
        logger.info("Rows affected: " + count);
        String termNoSQL = "select last_value from seq_trm;" ;
        TreeMap empty = null;
        int termNo = this.simpleJdbcTemplate.queryForInt(termNoSQL,empty);
        logger.info("****New Term registered - ref: " + termNo + "****");
        return termNo;
	}
	
	public List<Term> getTerm(int id){
		
		logger.info("get term, id= " + id);
		ArrayList<Term> termlist = (ArrayList) this.simpleJdbcTemplate.query(
                "select id, term, description from country where id=" + id, 
                new TermMapper());
		return termlist;

	}
	
	public void deleteAllTerms(){
		
		logger.info("delete term Records");
		int count = this.simpleJdbcTemplate.update("DELETE * FROM term");
        logger.info("Rows affected: " + count);

	}
	
	public void deleteTerm(int id){
		logger.info("delete term, id= " + id);
		int count = this.simpleJdbcTemplate.update("DELETE * FROM term WHERE id=" + id);
        logger.info("Rows affected: " + count);
		
	}
	
	public Boolean searchTerm(String tm){
		
		logger.info("Search Term = " + tm);
		ArrayList<Term> termlist = (ArrayList)this.simpleJdbcTemplate.query(
                "select id, term, description from country where term =" + tm, 
                new TermMapper());
		if (termlist.size()>0){
		   return true;
		}else{
			return false;
		}
		
	}
    public Term search(String tm){
		
		logger.info("Search Term = " + tm);
		ArrayList<Term> termlist = (ArrayList)this.simpleJdbcTemplate.query(
                "select id, term, description from term where term like '" + tm + "'", 
                new TermMapper());
		if (termlist.size()>0){
			Term searchTerm = new Term();
			Iterator<Term> itr = termlist.iterator();
		    while (itr.hasNext()) {
		    	searchTerm = itr.next();
		    }
		    return searchTerm;
		    
		}else{
			return null;
		}
		
	}
	
}
