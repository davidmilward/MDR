package uk.org.datalink.MDR.domain;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="valuedomain")
public class ValueDomain extends AdminObject {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private int valuedomainid;
	  private int maxchar;
	  private int unitofmeasure;
	  private int adminobjectid;
	  private int permissiblevalue;
	  private int termid;
	  private String format;
	  private int datatype;
	  private Boolean enumerated;
	  private Datatype dataType;
	  private UnitsOfMeasure unitsOfMeasure;
	  
	  public Datatype getDataType(){
		  return this.dataType;
	  }
	  public void setDataType(Datatype un){
		  this.dataType = un;
	  }
	  public UnitsOfMeasure getUnitsOfMeasure(){
		  return this.unitsOfMeasure;
	  }
	  public void setUnitsOfMeasure(UnitsOfMeasure un){
		  this.unitsOfMeasure = un;
	  }

	  public void setValuedomainid(int nid){
		  this.valuedomainid = nid;
	  }
	  public void setMaxchar(int mc){
		  this.maxchar = mc;
	  }
	  public void setUnitofmeasure(int uom){
		  this.unitofmeasure = uom;
	  }
	  public void setAdminobjectid(int oid){
		  this.adminobjectid = oid;
	  }
	  public void setPermissiblevalue(int pid){
		  this.permissiblevalue = pid;
	  }
	  public void setTermid(int tid){
		  this.termid = tid;
	  }
	  public void setFormat(String fm){
		  this.format = fm;
	  }
	  public void setDatatype(int dt){
		  this.datatype = dt;
	  }
	  public void setEnumerated(Boolean en){
		  this.enumerated = en;
	  }


	  public int getValuedomainid(){
		  return this.valuedomainid;
	  }
	  public int getMaxchar(){
		  return this.maxchar;
	  }
	  public int getUnitofmeasure(){
		  return this.unitofmeasure;
	  }
	  public int getAdminobjectid(){
		  return this.adminobjectid;
	  }
	  public int getPermissiblevalue(){
		  return this.permissiblevalue;
	  }
	  public int getTermid(){
		  return this.termid;
	  }
	  public String getFormat(){
		  return this.format;
	  }
	  public int getDatatype(){
		  return this.datatype;
	  }
	  public Boolean getEnumerated(){
		  return this.enumerated;
	  }

	  
}
