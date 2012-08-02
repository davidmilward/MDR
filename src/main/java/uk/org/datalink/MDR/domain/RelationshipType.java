package uk.org.datalink.MDR.domain;

public class RelationshipType {
	
	  private int id;
	  private String name;
	  private String description;


	  
	  public void setId(int nid){
		  this.id = nid;
	  }
	  public void setName(String nm ){
		  this.name = nm;
	  }
	  public void setDescription(String ds){
		  this.description = ds;
	  }
	  
	 
	  
	  
	  public int getId(){
		  return this.id;
	  }
	  public String getName(){
		  return this.name;
	  }
	  public String getDescription(){
		  return this.description;
	  }
	  
	

}
