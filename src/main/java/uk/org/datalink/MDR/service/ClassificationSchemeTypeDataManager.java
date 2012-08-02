package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.ClassificationSchemeType;

public interface ClassificationSchemeTypeDataManager {

	public int create(String des, String tname, String url );
	public int create(ClassificationSchemeType cs);
	public List<ClassificationSchemeType> getClassificationSchemeTypeDetails();
	public List<ClassificationSchemeType> getClassificationSchemeTypeDetail(int id);
	public void updateClassificationSchemeTypeDetails(ClassificationSchemeType obj); 
	public void deleteAll();
	public void delete(int id);
}
