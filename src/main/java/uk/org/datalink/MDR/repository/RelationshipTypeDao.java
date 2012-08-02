package uk.org.datalink.MDR.repository;

import java.util.ArrayList;
import java.util.List;

import uk.org.datalink.MDR.domain.RelationshipType;

public interface RelationshipTypeDao {

	public ArrayList<RelationshipType> getRelationshipTypeList();
	public void updateRelationshipType(RelationshipType rltObj);
	public int createRelationshipType(RelationshipType rltObj);
	public List<RelationshipType> getRelationshipType(int id);
	public void deleteAllRelationshipTypes();
	public void deleteRelationshipType(int id);
	
}
