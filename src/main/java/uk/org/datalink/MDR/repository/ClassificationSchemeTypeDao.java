package uk.org.datalink.MDR.repository;

import java.util.ArrayList;
import java.util.List;

import uk.org.datalink.MDR.domain.ClassificationSchemeType;

public interface ClassificationSchemeTypeDao {

	public void updateClassificationSchemeType(ClassificationSchemeType cstObj);
	public int createClassificationSchemeType(ClassificationSchemeType cstObj);
	public List<ClassificationSchemeType> getClassificationSchemeType(int id);
	public ArrayList<ClassificationSchemeType> getClassificationSchemeTypeList();
	public void deleteAllClassificationSchemeTypes();
	public void deleteClassificationSchemeType(int id);
	
}
