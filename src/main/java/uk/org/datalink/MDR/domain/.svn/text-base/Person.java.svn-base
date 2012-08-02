package uk.org.datalink.MDR.domain;

import java.util.Date;

public class Person {
	private int id;
	private String title;
	private String firstname;
	private String surname;
	private String otherNames;
	private String alias;
	private String fullName;
	private Date dob;
	private String notes;
	
	public void setId(int newID){
		this.id = newID;
	}
	
	public void setTitle(String newT){
		this.title = newT;
	}
	public void setFirstname(String fName){
		this.firstname = fName;
	}
	public void setSurname(String sName){
		this.surname = sName;
	}
	public void setOtherNames(String oName){
		this.otherNames = oName;
	}
	public void setAlias(String ali){
		this.alias = ali;
	}
	public void setDob(Date db){
		this.dob = db;
	}
	public void setNotes(String nt){
		this.notes = nt;
	}
	
	public String getFullName(){
		StringBuffer sb = new StringBuffer();
		String spacer = " ";
		sb.append(this.getTitle());
		sb.append(spacer);
		sb.append(this.getFirstname());
		sb.append(spacer);
		sb.append(this.getSurname());
		return sb.toString();
	}
	
	public boolean isNew() {
		return (this.id == 0);
	}
	
	public int getId(){
		return this.id;
	}
	public String getTitle(){
		return this.title;
	}
	public String getFirstname(){
		return this.firstname;
	}
	public String getSurname(){
		return this.surname;
	}
	public String getOtherNames(){
		return this.otherNames;
	}
	public String getAlias(){
		return this.alias;
	}
	public Date getDob(){
		return this.dob;
	}
	public String getNotes(){
		return this.notes;
	}
	
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append("id=" + id + ": Title=" + title + " : firstname=" 
				+ firstname + " : surname=" + surname + " : otherNames=" 
				+ " : alias=" + alias 
				+ " : dob=" + dob);
		return buf.toString();
	}
}
