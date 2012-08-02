package uk.org.datalink.MDR.domain;



import junit.framework.TestCase;
import uk.org.datalink.MDR.domain.Address;


public class AddressTests extends TestCase {
	
	private Address address;

    protected void setUp() throws Exception {
    	address = new Address();
    }

    public void testSetAndGetAddress1() {
        String testAddressLine = "Kingston Hall";
        assertNull(address.getAddress1());
        address.setAddress1(testAddressLine);
        assertEquals(testAddressLine,  address.getAddress1());
    }
    
    public void testSetAndGetAddress2() {
        String testAddressLine = "Bow Street";
        assertNull(address.getAddress2());
        address.setAddress2(testAddressLine);
        assertEquals(testAddressLine,  address.getAddress2());
    }
    
    public void testSetAndGetTown() {
        String testAddressLine = "Oxford";
        assertNull(address.getTown());
        address.setTown(testAddressLine);
        assertEquals(testAddressLine,  address.getTown());
    }
    
    public void testSetAndGetRegion() {
        String testAddressLine = "North Holland";
        assertNull(address.getRegion());
        address.setRegion(testAddressLine);
        assertEquals(testAddressLine,  address.getRegion());
    }
    
    public void testSetAndGetPostcode() {
        String testAddressLine = "TQ7 6YU";
        assertNull(address.getPostcode());
        address.setPostcode(testAddressLine);
        assertEquals(testAddressLine,  address.getPostcode());
    }
    
    
    

}
