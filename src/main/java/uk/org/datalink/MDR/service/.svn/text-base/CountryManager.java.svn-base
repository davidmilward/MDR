package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.Country;
import uk.org.datalink.MDR.repository.JDBCCountryDao;

/*
 * This service class is for creating, updating and deleting Country objects
 */
public class CountryManager implements CountryDataManager{

	private static final long serialVersionUID = 1L;
	private JDBCCountryDao countryDao;
	
	public void setCountryDao(JDBCCountryDao cntDao){
		this.countryDao = cntDao;
	}
	
	public JDBCCountryDao getCountryDao(){
		return this.countryDao;
	}
	
	public int create(Country cntObj ){	
		int cid = countryDao.createCountry(cntObj);
		return cid;	
	}
	
	public int create(String abbr2, String abbr3, String  name ){
		int cid = 0;
		Country cntObj = new Country();
		cntObj.setAbbr2(abbr2);
		cntObj.setAbbr3(abbr3);
		cntObj.setName(name);
		cid = countryDao.createCountry(cntObj);
		return cid;	
	}
	
	public List<Country> getCountries(){
		List<Country> cntlist = countryDao.getCountryList();
		return cntlist;
	}
	public List<Country> getCountry(int id){
		List<Country> cntlist = countryDao.getCountry(id);
		return cntlist;
	}
	public void updateCountry(Country obj){
		countryDao.updateCountry(obj);
	}
	public void deleteAll(){
		countryDao.deleteAllCountry();
	}
	public void delete(int id){
		countryDao.deleteCountry(id);
	}
}
