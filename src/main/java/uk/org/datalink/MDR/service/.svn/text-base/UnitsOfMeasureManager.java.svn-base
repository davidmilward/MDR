package uk.org.datalink.MDR.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import uk.org.datalink.MDR.domain.UnitsOfMeasure;
import uk.org.datalink.MDR.repository.JDBCUnitOfMeasureDao;

public class UnitsOfMeasureManager {

	private static final long serialVersionUID = 1L;
	private JDBCUnitOfMeasureDao uomDao;
	
	@Autowired
	public void setUomDao(JDBCUnitOfMeasureDao um){
		this.uomDao = um;
	}
	
	public JDBCUnitOfMeasureDao getUomDao(){
		return this.uomDao;
	}
	
	public int create(String name, String description, int dimensionid ){
		int uid = 0;
		UnitsOfMeasure uomObj = new UnitsOfMeasure();
		uomObj.setName(name);
		uomObj.setDescription(description);
		uomObj.setDimension(dimensionid);
		uid = uomDao.createUnitsOfMeasure(uomObj);
		return uid;	
	}
	
	public int create(UnitsOfMeasure  uomObj ){
		int uid = 0;
		uid = uomDao.createUnitsOfMeasure(uomObj);
		return uid;	
	}
	
	public List<UnitsOfMeasure> getUnitsOfMeasures(){
		return this.uomDao.getUnitsOfMeasureList();
	}
	public List<UnitsOfMeasure> getUnitsOfMeasureList(int id){
		return this.uomDao.getUnitsOfMeasureList(id);
	}
	public UnitsOfMeasure getUnitsOfMeasure(int id){
		return this.uomDao.getUnitsOfMeasure(id);
	}
	public void updateUnitsOfMeasure(UnitsOfMeasure obj){
		this.uomDao.updateUnitsOfMeasure(obj);
	}
	public void deleteAll(){
		this.uomDao.deleteAllUnitsOfMeasures();
	}
	public void delete(int id){
		this.uomDao.deleteUnitsOfMeasure(id);	
	}
}
