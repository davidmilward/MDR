package uk.org.datalink.MDR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.org.datalink.MDR.domain.Model;
import uk.org.datalink.MDR.repository.JDBCModelDao;


@Service
public class ModelManager implements ModelDataManager {
		private static final long serialVersionUID = 1L;
		private JDBCModelDao modelDao;
		@Autowired
		public void setModelDao(JDBCModelDao mdDao){
			this.modelDao = mdDao;
		}

		public JDBCModelDao getModelDao(){
			return this.modelDao;
		}

		public int create(String nm, String nms, String  desc, int adid ){
			int mid = 0;
			Model mdObj = new Model();
			mdObj.setAdminobjectid(adid);
			mdObj.setName(nm);
			mdObj.setNamespace(nms);
			mdObj.setDescription(desc);
			mid = create(mdObj);
			return mid;	
		}
		
		public int create( Model mdObj ){
			int aid = 0;
			aid = modelDao.createModel(mdObj);
			return aid;	
		}
		public Model getModel(int id){
			Model mdl = modelDao.getModel(id);
			return mdl;
		}
		public List<Model> getModelDetails(){
			List<Model> mdlist = modelDao.getModelList();
			return mdlist;
		}
		public List<Model> getModelDetail(int id){
			List<Model> mdlist = modelDao.getModelList(id);
			return mdlist;
		}
		public void updateModelDetails(Model mdObj){
			modelDao.updateModel(mdObj);
		}
		public void deleteAll(){
			modelDao.deleteAllModels();
		}
		public void delete(int id){
			modelDao.deleteModel(id);
		}
}
