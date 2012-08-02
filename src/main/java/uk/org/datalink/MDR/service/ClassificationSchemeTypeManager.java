package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.ClassificationSchemeType;
import uk.org.datalink.MDR.repository.JDBCClassificationSchemeTypeDao;

public class ClassificationSchemeTypeManager implements ClassificationSchemeTypeDataManager {
	private static final long serialVersionUID = 1L;
	private JDBCClassificationSchemeTypeDao classificationSchemeTypeDao;

	public void setClassificationSchemeTypeDao(JDBCClassificationSchemeTypeDao csDao){
		this.classificationSchemeTypeDao = csDao;
	}

	public JDBCClassificationSchemeTypeDao getClassificationSchemeTypeDao(){
		return this.classificationSchemeTypeDao;
	}

	public int create(String des, String tname, String url ){
		int aid = 0;
		ClassificationSchemeType cstObj = new ClassificationSchemeType();
		cstObj.setDescription(des);
		cstObj.setTypename(tname);
		cstObj.setUrl(url);
		aid = create(cstObj);
		return aid;	
	}
	
	public int create( ClassificationSchemeType cstObj ){
		int aid = 0;
		aid = classificationSchemeTypeDao.createClassificationSchemeType(cstObj);
		return aid;	
	}
	public List<ClassificationSchemeType> getClassificationSchemeTypeDetails(){
		List<ClassificationSchemeType> cstlist = classificationSchemeTypeDao.getClassificationSchemeTypeList();
		return cstlist;
	}
	public List<ClassificationSchemeType> getClassificationSchemeTypeDetail(int id){
		List<ClassificationSchemeType> cstlist = classificationSchemeTypeDao.getClassificationSchemeType(id);
		return cstlist;
	}
	public void updateArtefactDetails(ClassificationSchemeType cstObj){
		classificationSchemeTypeDao.updateClassificationSchemeType(cstObj);
	}
	public void deleteAll(){
		classificationSchemeTypeDao.deleteAllClassificationSchemeTypes();
	}
	public void delete(int id){
		classificationSchemeTypeDao.deleteClassificationSchemeType(id);
	}

	public void updateClassificationSchemeTypeDetails(ClassificationSchemeType cstObj) {
		classificationSchemeTypeDao.updateClassificationSchemeType(cstObj);
	}




	
	
	
}
