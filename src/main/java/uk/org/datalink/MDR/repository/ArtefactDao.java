package uk.org.datalink.MDR.repository;

import java.util.ArrayList;
import java.util.List;

import uk.org.datalink.MDR.domain.Artefact;

 

public interface ArtefactDao {

	public ArrayList<Artefact> getArtefactList();
	public void updateArtefact(Artefact cntObj);
	public void saveArtefact(Artefact cntObj);
	public int createArtefact(Artefact cntObj);
	public List<Artefact> getArtefactList(int id);
	public Artefact getArtefact(int id);
	public void deleteAllArtefacts();
	public void deleteArtefact(int id);
	
}
