package uk.org.datalink.MDR.domain;


import junit.framework.TestCase;
import uk.org.datalink.MDR.domain.Artefact;

public class ArtefactTests extends TestCase {
	
	private Artefact artefact;
	private int modelid;
	private int externalid;
	private String artefacturl;
	private String notes;

    protected void setUp() throws Exception {
    	artefact = new Artefact();
    }

    public void testSetAndGetModelId() {
        int testModelId = 888;
        assertEquals(artefact.getModelid(),0);
        artefact.setModelid(888);
        assertEquals(888,  artefact.getModelid());
    }
    
    public void testSetAndGetExternalId() {
    	int testExternalId = 0;
    	assertEquals(artefact.getExternalid(),0);
        artefact.setModelid(testExternalId);
        assertEquals(testExternalId,  artefact.getExternalid());
    }
    
    public void testSetAndGetArtefactUrl() {
    	String artefactUrl = "http://datalink.org.uk/repository/vocab1";
        assertNull(artefact.getArtefacturl());
        artefact.setArtefacturl(artefactUrl);
        assertEquals(artefactUrl,  artefact.getArtefacturl());
    }
    
    public void testSetAndGetNotes() {
        String Notes = "These are some notes - test them";
        assertNull(artefact.getNotes());
        artefact.setNotes(Notes);
        assertEquals(Notes,  artefact.getNotes());
    }
    

    
}
