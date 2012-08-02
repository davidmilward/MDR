package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.ValueDomain;

public interface ValueDomainDataManager {
	public int create(String name, String description, int dimensionid );
	public List<ValueDomain> getValueDomains();
	public List<ValueDomain> getValueDomain(int id);
	public void updateValueDomain(ValueDomain obj); 
	public void deleteAll();
	public void delete(int id);
}
