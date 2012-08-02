package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.UnitsOfMeasure;

public interface UnitsOfMeasureDataManager {
	public int create(String name, String description, int dimensionid );
	public List<UnitsOfMeasure> getUnitsOfMeasures();
	public List<UnitsOfMeasure> getUnitsOfMeasure(int id);
	public void updateUnitsOfMeasure(UnitsOfMeasure obj); 
	public void deleteAll();
	public void delete(int id);
}
