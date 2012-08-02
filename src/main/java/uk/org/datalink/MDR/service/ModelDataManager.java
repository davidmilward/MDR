package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.Model;

public interface ModelDataManager {

	public int create(String name, String namespace, String  description, int adminobjectid );
	public int create(Model md);
	public Model getModel(int id);
	public List<Model> getModelDetails();
	public List<Model> getModelDetail(int id);
	public void updateModelDetails(Model obj); 
	public void deleteAll();
	public void delete(int id);
}
