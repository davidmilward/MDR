package uk.org.datalink.MDR.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ChangeAdminStatus {

	private int adminStatus;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	public void setAdminStatus(int nstatus){
		this.adminStatus = nstatus;
	}
	
	public int getAdminStatus(){
		return this.adminStatus;
	}
	
	
}
