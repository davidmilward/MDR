package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.RelationshipType;
import uk.org.datalink.MDR.repository.JDBCRelationshipTypeDao;


public class RelationshipTypeManager implements RelationshipTypeDataManager {

	private static final long serialVersionUID = 1L;
	private JDBCRelationshipTypeDao rltDao;
	
	public void setRltDao(JDBCRelationshipTypeDao rd){
		this.rltDao = rd;
	}
	
	public JDBCRelationshipTypeDao getRltDao(){
		return this.rltDao;
	}
	
	public int create(String nm, String ds ){
		int rid = 0;
		RelationshipType reltObj = new RelationshipType();
		reltObj.setName(nm);
		reltObj.setDescription(ds);
		rid = rltDao.createRelationshipType(reltObj);
		return rid;	
	}
	
	public int create(RelationshipType reltObj){
		int rid = 0;
		rid = rltDao.createRelationshipType(reltObj);
		return rid;	
	}
	
	public List<RelationshipType> getRelationshipTypes(){
		return this.rltDao.getRelationshipTypeList();
	}
	
	public List<RelationshipType> getRelationshipType(int id){
		return this.rltDao.getRelationshipType(id);
	}
	
	public void updateRelationshipType(RelationshipType robj){ 
		this.rltDao.updateRelationshipType(robj);
	}
	
	public void deleteAll(){
		this.rltDao.deleteAllRelationshipTypes();
	}
	
	public void delete(int id){
		this.rltDao.deleteRelationshipType(id);
	}
	
	
}
