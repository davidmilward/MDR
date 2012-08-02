package uk.org.datalink.MDR.domain;

import junit.framework.TestCase;
import uk.org.datalink.MDR.domain.DataElement;

public class DataElementTests extends TestCase {
	
	private DataElement dataelement;

    protected void setUp() throws Exception {
    	dataelement = new DataElement();
    }

	  
	  public void testSetAndGetID() {
		  int dataElementID = 888;
	      assertEquals(dataelement.getDataElementId(),0);
	      dataelement.setDataElementId(dataElementID);
	      assertEquals(dataElementID,  dataelement.getDataElementId());
	  }
	  
	  public void testSetAndGetValueDomainID() {
		  int valueDomainID = 888;
	      assertEquals(dataelement.getValueDomainID(),0);
	      dataelement.setValueDomainID(valueDomainID);
	      assertEquals(valueDomainID,  dataelement.getValueDomainID());
	  }
	  
	  public void testSetAndGetAdminObjectID() {
		  int adminObjectID = 888;
	      assertEquals(dataelement.getAdminobjectid(),0);
	      dataelement.setAdminobjectid(adminObjectID);
	      assertEquals(adminObjectID,  dataelement.getAdminobjectid());
	  }
	  
	  public void testSetAndGetClassificationSchemeID() {
		  int classificationSchemeID = 888;
	      assertEquals(dataelement.getClassificationSchemeID(),0);
	      dataelement.setClassificationSchemeID(classificationSchemeID);
	      assertEquals(classificationSchemeID,  dataelement.getClassificationSchemeID());
	  }
	  
     public void testSetAndGetDefinition() {
        String testDefinition = "Data Element Definition";
        assertNull(dataelement.getDefinition());
        dataelement.setDefinition(testDefinition);
        assertEquals(testDefinition,  dataelement.getDefinition());
     }
     
     public void testSetAndGetDescription() {
         String testDescription = "Data Element Description";
         assertNull(dataelement.getDescription());
         dataelement.setDescription(testDescription);
         assertEquals(testDescription,  dataelement.getDescription());
      }


}
