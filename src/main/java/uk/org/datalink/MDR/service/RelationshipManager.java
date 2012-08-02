package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.Relationship;
import uk.org.datalink.MDR.repository.JDBCRelationshipDao;

public class RelationshipManager implements RelationshipDataManager {
    
	private static final long serialVersionUID = 1L;
	private JDBCRelationshipDao rlDao;
	
	public void setRlDao(JDBCRelationshipDao rd){
		this.rlDao = rd;
	}
	
	public JDBCRelationshipDao getRlDao(){
		return this.rlDao;
	}
	
	public int create(int classschemeId, int subjectId, int objectId, int typeId ){
		int rid = 0;
		Relationship relObj = new Relationship();
		relObj.setClassscheme_id(classschemeId);
		relObj.setSubject_id(subjectId);
		relObj.setObj_id(objectId);
		relObj.setType_id(typeId);
		rid = rlDao.createRelationship(relObj);
		return rid;	
	}
	
	public int create(Relationship relObj){
		int rid = 0;
		rid = rlDao.createRelationship(relObj);
		return rid;	
	}
	
	public List<Relationship> getRelationships(){
		return this.rlDao.getRelationshipList();
	}
	
	public List<Relationship> getRelationshipItem(int id){
		return this.rlDao.getRelationshipListItem(id);
	}
	
	public Relationship getRelationship(int id){
		return this.rlDao.getRelationship(id);
	}
	
	public void updateRelationship(Relationship robj){ 
		this.rlDao.updateRelationship(robj);
	}
	
	public void deleteAll(){
		this.rlDao.deleteAllRelationship();
	}
	
	public void delete(int id){
		this.rlDao.deleteRelationship(id);
	}

}
