package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.RelationshipType;

public interface RelationshipTypeDataManager {

	public int create(String name, String description );
	public List<RelationshipType> getRelationshipTypes();
	public List<RelationshipType> getRelationshipType(int id);
	public void updateRelationshipType(RelationshipType obj); 
	public void deleteAll();
	public void delete(int id);
}
