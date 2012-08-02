package uk.org.datalink.MDR.domain;

/**
 * Returns an Image object that can then be painted on the screen. 
 * The url argument must specify an absolute {@link URL}. The name
 * argument is a specifier that is relative to the url argument. 
 * <p>
 * This method always returns immediately, whether or not the 
 * image exists. When this applet attempts to draw the image on
 * the screen, the data will be loaded. The graphics primitives 
 * that draw the image will incrementally paint on the screen. 
 *
 * @author David Milward
 * @version %I%, %G%
 */



public class Address {

	  private int id;
	  private String address1;
	  private String address2;
	  private String town;
	  private String region;
	  private String postcode;
	  
	  public void setId(int nid){
		  this.id = nid;
	  }
	  public void setAddress1(String add1){
		  this.address1 = add1;
	  }
	  public void setAddress2(String add2){
		  this.address2 = add2;
	  }
	  public void setTown(String tn){
		  this.town = tn;
	  }
	  public void setRegion(String rg){
		  this.region = rg;
	  }
	  public void setPostcode(String pc){
		  this.postcode = pc;
	  }
	  
	  public int getId(){
		  return this.id;
	  }
	  public String getAddress1(){
		  return this.address1;
	  }
	  public String getAddress2(){
		  return this.address2;
	  }
	  public String getTown(){
		  return this.town;
	  }
	  public String getRegion(){
		  return this.region;
	  }
	  public String getPostcode(){
		  return this.postcode;
	  }
	  
	  
}
