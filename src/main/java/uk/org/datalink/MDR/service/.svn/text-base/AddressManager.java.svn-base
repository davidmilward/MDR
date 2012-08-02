package uk.org.datalink.MDR.service;

import java.util.List;

import uk.org.datalink.MDR.domain.Address;
import uk.org.datalink.MDR.repository.JDBCAddressDao;

public class AddressManager implements AddressDataManager {
	
	private static final long serialVersionUID = 1L;
	private JDBCAddressDao addressDao;

	public void setCountryDao(JDBCAddressDao addDao){
		this.addressDao = addDao;
	}

	public JDBCAddressDao getCountryDao(){
		return this.addressDao;
	}

	public int create(String addr1, String addr2, String  town, String region, String pc ){
		int cid = 0;
		Address addObj = new Address();
		addObj.setAddress1(addr1);
		addObj.setAddress2(addr2);
		addObj.setTown(town);
		addObj.setRegion(region);
		addObj.setPostcode(pc);
		cid = addressDao.createAddress(addObj);
		return cid;	
	}
	public List<Address> getAddressDetails(){
		List<Address> addlist = addressDao.getAddressList();
		return addlist;
	}
	public List<Address> getAddressDetail(int id){
		List<Address> addlist = addressDao.getAddress(id);
		return addlist;
	}
	public void updateAddressDetails(Address obj){
		addressDao.updateAddress(obj);
	}
	public void deleteAll(){
		addressDao.deleteAllAddress();
	}
	public void delete(int id){
		addressDao.deleteAddress(id);
	}
}


