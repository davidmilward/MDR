package uk.org.datalink.MDR.domain;

public class Model extends AdminObject {


	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	  private int adminid;
	  private String namespace;
	  private String description;
	  private String name;
	  
	  public void setId(int nid){
		  this.id = nid;
	  }
	  public void setAdminid(int adid){
		  this.adminid = adid;
	  }
	  public void setNamespace(String tid){
		  this.namespace = tid;
	  }
	  public void setDescription(String desc){
		  this.description = desc;
	  }
	  public void setName(String nm){
		  this.name = nm;
	  }
	  
	  
	  public int getId(){
		  return this.id;
	  }
	  public int getAdminid(){
		  return this.adminid;
	  }
	  public String getDescription(){
		  return this.description;
	  }
	  public String getNamespace(){
		  return this.namespace;
	  }
	  public String getName(){
		  return this.name;
	  }
	
}
