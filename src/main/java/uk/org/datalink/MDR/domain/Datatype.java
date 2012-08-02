package uk.org.datalink.MDR.domain;

public class Datatype {

	
	  private int id;
	  private String identifier;
	  private String dataTypeName;
	  private String scheme;
	  private String description;
	  
		public void setId(int nid){
			this.id = nid;
		}
		public void setIdentifier(String nident){
			this.identifier = nident;  
		}
		public void setDataTypeName(String dtName){
			this.dataTypeName = dtName;
		}
		public void setScheme(String sch){
			this.scheme = sch;
		}
		public void setDescription(String desc){
			this.description = desc;
		}
		
		public int getId(){
			return this.id;
		}
		public String getIdentifier(){
			return this.identifier;  
		}
		public String getDataTypeName(){
			return this.dataTypeName;
		}
		public String getScheme(){
			return this.scheme;
		}
		public String getDescription(){
			return this.description;
		}

}
