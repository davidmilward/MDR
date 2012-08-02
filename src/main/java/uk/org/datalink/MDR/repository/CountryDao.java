package uk.org.datalink.MDR.repository;

import java.util.ArrayList;
import java.util.List;

import uk.org.datalink.MDR.domain.Country;


public interface CountryDao {
	
	public ArrayList<Country> getCountryList();
	public void updateCountry(Country cntObj);
	public void saveCountry(Country cntObj);
	public int createCountry(Country cntObj);
	public List<Country> getCountry(int id);
	public void deleteAllCountry();
	public void deleteCountry(int id);
	
}


