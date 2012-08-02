package uk.org.datalink.MDR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.org.datalink.MDR.domain.Artefact;
import uk.org.datalink.MDR.repository.JDBCArtefactDao;

@Service
public class ArtefactManager implements ArtefactDataManager {
	private static final long serialVersionUID = 1L;
	private JDBCArtefactDao artefactDao;
	@Autowired
	public void setArtefactDao(JDBCArtefactDao actDao){
		this.artefactDao = actDao;
	}

	public JDBCArtefactDao getArtefactDao(){
		return this.artefactDao;
	}

	public int create(String url, int modelId, String  nts, int refId ){
		int aid = 0;
		Artefact artObj = new Artefact();
		artObj.setExternalid(refId);
		artObj.setModelid(modelId);
		artObj.setArtefacturl(url);
		artObj.setNotes(nts);
		aid = create(artObj);
		return aid;	
	}
	
	public int create( Artefact artObj ){
		int aid = 0;
		aid = artefactDao.createArtefact(artObj);
		return aid;	
	}
	public List<Artefact> getArtefactDetails(){
		List<Artefact> addlist = artefactDao.getArtefactList();
		return addlist;
	}
	public List<Artefact> getArtefactDetail(int id){
		List<Artefact> artlist = artefactDao.getArtefactList(id);
		return artlist;
	}
	public Artefact getArtefact(int id){
		Artefact art = artefactDao.getArtefact(id);
		return  art;
	}
	public void updateArtefactDetails(Artefact obj){
		artefactDao.updateArtefact(obj);
	}
	public void deleteAll(){
		artefactDao.deleteAllArtefacts();
	}
	public void delete(int id){
		artefactDao.deleteArtefact(id);
	}
}
