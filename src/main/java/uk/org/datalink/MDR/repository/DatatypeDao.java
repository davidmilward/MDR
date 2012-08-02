package uk.org.datalink.MDR.repository;

import java.util.ArrayList;
import uk.org.datalink.MDR.domain.Datatype;


public interface DatatypeDao {

	public ArrayList<Datatype> getDatatypeList();
	public void updateDatatype(Datatype dtObj);
	//public void saveDatatype(Datatype dtObj);
	public int createDatatype(Datatype dtObj);
	//public List<Datatype> getDatatypeList(int id);
	public Datatype getDatatype(int id);
	public void deleteAllDatatypes();
	public void deleteDatatype(int id);
	
}
