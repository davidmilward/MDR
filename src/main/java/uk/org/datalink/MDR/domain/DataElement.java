package uk.org.datalink.MDR.domain;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * <p>This is the Data Element class, it is a child of the AdminObject class</p> 
 * <p>It holds details on who did what to the object, namely:</p> 
 * <p>The key properties of the data element are its description, </p> 
 * <p>its definition and its relationship with its value domain and </p> 
 * <p>classification scheme</p> 
 * <p></p> 
 * <p></p> 
 * <p></p> 
 * <p></p>    
 * <p></ul></p> 
 *  
 *
 * @author David Milward
 * @version %I%, %G%
 */

//@XStreamAlias("dataElement") 
@XmlRootElement(name="dataElement")
public class DataElement extends AdminObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int adminobjectid;
	private int valueDomainID;
	private int termID;
	private String description;
	private String definition;
	private int classificationSchemeID;
	private int dataElementId;
	private boolean nw = false;
	private String classificationSchemeIDString;
	
	
	public String getClassificationSchemeIDString(){
		return classificationSchemeIDString;
	}
	public void setClassificationSchemeIDString(String csname){
		classificationSchemeIDString = csname;
	}
	
	public boolean getNw(){
		return nw;
	}
	public void setNw(boolean isnew){
		this.nw = isnew;
	}

	public void setAdminobjectid(int adminObjId){
		this.adminobjectid = adminObjId;
	}
	public void setValueDomainID(int vdId){
		this.valueDomainID = vdId;
	}
	public void setDescription(String desc){
		this.description = desc;
	}
	public void setDefinition(String def){
		this.definition = def;
	}
	public void setClassificationSchemeID(int conId){
		this.classificationSchemeID = conId;
	}
	public void setDataElementId(int id){
		this.dataElementId = id;
	}
	public void setTermID(int id){
		this.termID = id;
	}

 	public int getTermID(){
		return this.termID;
	}
	public int getAdminobjectid(){
		return this.adminobjectid;
	}
	public int getValueDomainID(){
		return this.valueDomainID;
		
	}
	public String getDescription(){
		return this.description;
		
	}
	public String getDefinition(){
		return this.definition;
	}
	public int getClassificationSchemeID(){
		return this.classificationSchemeID;
	}
	public int getDataElementId(){
		return this.dataElementId;
	}
	
	public String toString() {
		
		  StringBuffer buffer = new StringBuffer();
		  buffer.append(super.toString());
		  buffer.append("DATAELEMENT - AdminObj:" + this.getAdminobjectid() + ";" + "\r\n" );
		  buffer.append("DATAELEMENT - Definition:" + this.getDefinition() + ";" + "\r\n");
		  buffer.append("DATAELEMENT - Description:" + this.getDescription() + ";" + "\r\n");
		  buffer.append("DATAELEMENT - ID:" + this.getDataElementId() + ";" + "\r\n");
		  buffer.append("DATAELEMENT - getClassificationSchemeID:" + this.getClassificationSchemeID() + ";" + "\r\n");
		  
	      return buffer.toString();
		}
	
}
