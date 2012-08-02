package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.Term;

public interface TermDataManager {

	public int create(String name, String description );
	public List<Term> getTerms();
	public List<Term> getTerm(int id);
	public void updateTerm(Term obj); 
	public void deleteAll();
	public void delete(int id);
	
}
