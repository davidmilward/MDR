package uk.org.datalink.MDR.domain;


import java.util.Date;

import junit.framework.TestCase;
import uk.org.datalink.MDR.domain.Person;



public class PersonTests extends TestCase{

	private Person person;
	
	protected void setUp() throws Exception {
		person = new Person();
    }
	
	public void testSetAndGetAlias() {
        String alias  = "John Smith";
        assertNull(person.getAlias());
        person.setAlias(alias);
        assertEquals(alias,  person.getAlias());
    }
    
    public void testSetAndGetDob() {
    	Date testDate = new Date();
    	assertEquals(person.getDob(), null);
        person.setDob(testDate);
        assertEquals(testDate, person.getDob());
    }
    
    public void testSetAndGetFirstName() {
    	String firstName = "John";
        assertNull(person.getFirstname());
        person.setFirstname(firstName);
        assertEquals(firstName,  person.getFirstname());
    }
    
    public void testSetAndGetSurname() {
        String surName = "Smith";
        assertNull(person.getSurname());
        person.setSurname(surName);
        assertEquals(surName,  person.getSurname());
    }
	
	
	
	
	
}
