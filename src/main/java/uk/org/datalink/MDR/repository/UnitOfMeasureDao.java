package uk.org.datalink.MDR.repository;

import java.util.ArrayList;
import java.util.List;

import uk.org.datalink.MDR.domain.UnitsOfMeasure;

public interface UnitOfMeasureDao {
	
	public ArrayList<UnitsOfMeasure> getUnitsOfMeasureList();
	public void updateUnitsOfMeasure(UnitsOfMeasure rlObj);
	public int createUnitsOfMeasure(UnitsOfMeasure rlObj);
	public List<UnitsOfMeasure> getUnitsOfMeasureList(int id);
	public UnitsOfMeasure getUnitsOfMeasure(int id);
	public void deleteAllUnitsOfMeasures();
	public void deleteUnitsOfMeasure(int id);
}
