package uk.org.datalink.MDR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uk.org.datalink.MDR.domain.ClassificationScheme;
import uk.org.datalink.MDR.repository.JDBCClassificationSchemeDao;
import uk.org.datalink.MDR.repository.JDBCClassificationSchemeTypeDao;
import uk.org.datalink.MDR.repository.JDBCRelationshipDao;
import uk.org.datalink.MDR.repository.JDBCRelationshipTypeDao;

@Service
public class ClassificationSchemeManager implements ClassificationSchemeDataManager {
	private static final long serialVersionUID = 1L;
	private JDBCClassificationSchemeDao classificationSchemeDao;
	private JDBCClassificationSchemeTypeDao classificationSchemeTypeDao;
	private JDBCRelationshipDao relationshipDao;
	private JDBCRelationshipTypeDao relationshipTypeDao;
	
	@Autowired
	public void setClassificationSchemeDao(JDBCClassificationSchemeDao csDao){
		this.classificationSchemeDao = csDao;
	}

	public JDBCClassificationSchemeDao getClassificationSchemeDao(){
		return this.classificationSchemeDao;
	}
	
	@Autowired
	public void setClassificationSchemeTypeDao(JDBCClassificationSchemeTypeDao cstDao){
		this.classificationSchemeTypeDao = cstDao;
	}

	public JDBCClassificationSchemeTypeDao getClassificationSchemeTypeDao(){
		return this.classificationSchemeTypeDao;
	}
	
	@Autowired
	public void setJDBCRelationshipTypeDao(JDBCRelationshipTypeDao rltDao){
		this.relationshipTypeDao = rltDao;
	}

	public JDBCRelationshipTypeDao getJDBCRelationshipTypeDao(){
		return this.relationshipTypeDao;
	}
	
	@Autowired
	public void setJDBCRelationshipDao(JDBCRelationshipDao rlDao){
		this.relationshipDao = rlDao;
	}

	public JDBCRelationshipDao getJDBCRelationshipDao(){
		return this.relationshipDao;
	}

	public int create(String des, int refId ){
		int aid = 0;
		ClassificationScheme csObj = new ClassificationScheme();
		csObj.setDescription(des);
		csObj.setSchemeType(refId);
		aid = create(csObj);
		return aid;	
	}
	
	public int createFromSkos(Document xmlDoc){
		
		int aid = 0;
		//aid = classificationSchemeDao.createClassificationScheme(xmlDoc);
		Element rootElement = xmlDoc.getDocumentElement();
		ClassificationScheme newScheme = new ClassificationScheme();
		newScheme.setName(rootElement.getTagName());
		newScheme.setSchemeType(1);//Assume 1 ==SKOS for now - 
		newScheme.setDescription(xmlDoc.getNamespaceURI());
		classificationSchemeDao.createClassificationScheme(newScheme);
		//Now parse document to store element relationships
		
		
		
		
		
		
		
		
		
		
		return aid;	

	}
	
	public int create( ClassificationScheme artObj ){
		int aid = 0;
		aid = classificationSchemeDao.createClassificationScheme(artObj);
		return aid;	
	}
	public List<ClassificationScheme> getClassificationSchemeDetails(){
		List<ClassificationScheme> cslist = classificationSchemeDao.getClassificationSchemeList();
		return cslist;
	}
	
	public ClassificationScheme getClassificationScheme(int id){
		ClassificationScheme cs = classificationSchemeDao.getClassificationScheme(id);
		return cs;
	}
	public List<ClassificationScheme> getClassificationSchemeDetail(int id){
		List<ClassificationScheme> cslist = classificationSchemeDao.getClassificationSchemeListItem(id);
		return cslist;
	}
	public void updateArtefactDetails(ClassificationScheme csObj){
		classificationSchemeDao.updateClassificationScheme(csObj);
	}
	public void deleteAll(){
		classificationSchemeDao.deleteAllClassificationScheme();
	}
	public void delete(int id){
		classificationSchemeDao.deleteClassificationScheme(id);
	}


	public void updateClassificationSchemeDetails(ClassificationScheme csObj) {
		classificationSchemeDao.updateClassificationScheme(csObj);
	}
	
	
	
	




}
