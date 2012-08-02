package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.Term;
import uk.org.datalink.MDR.repository.JDBCTermDao;


public class TermManager implements TermDataManager{
	
	private static final long serialVersionUID = 1L;
	private JDBCTermDao tmDao;
	
	public int create(String name, String description ){
		Term newTerm = new Term();
		newTerm.setTerm(name);
		newTerm.setDescription(description);
		int termid = tmDao.createTerm(newTerm);
		newTerm.setId(termid);
		return termid;
	}
	
	public List<Term> getTerms(){
		
		List<Term> terms = tmDao.getTermList();
		return terms;
	}
	
	public List<Term> getTerm(int id){
		List<Term> term = tmDao.getTerm(id);
		return term;
	}
	
	public void updateTerm(Term obj){
		tmDao.updateTerm(obj);
	}
	
	public void deleteAll(){
		tmDao.deleteAllTerms();
	}
	
	public void delete(int id){
		tmDao.deleteTerm(id);
	}

	

}
