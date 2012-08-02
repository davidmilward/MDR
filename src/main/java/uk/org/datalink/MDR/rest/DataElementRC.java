package uk.org.datalink.MDR.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;


import uk.org.datalink.MDR.domain.DataElement;
import uk.org.datalink.MDR.domain.Person;
import uk.org.datalink.MDR.service.CreateDataElement;
import uk.org.datalink.MDR.service.DataElementManager;
import uk.org.datalink.MDR.service.PersonManager;
import uk.org.datalink.MDR.web.ResourceNotFoundException;


@Path("/dataelement")
public class DataElementRC {
 
	protected final Log logger = LogFactory.getLog(getClass());
	private DataElementManager dataManager;
	private PersonManager peopleManager;
	@Autowired
	public void setDataManager(DataElementManager datamanager) {
		logger.info("setDataManager" );
        this.dataManager = datamanager;
    }
	
	public DataElementManager getDataManager(){
		return this.dataManager;
	}
	@Autowired
	public void setPeopleManager(PersonManager pm) {
        this.peopleManager = pm;
    }
	
	public PersonManager getPeopleManager(){
		return this.peopleManager;
	}
	
	@GET
	@Path("{deid}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public DataElement getDataElement(@PathParam("deid") String deid){
		
		int id = Integer.parseInt(deid);
		logger.info("getting data element:" + id);
		if(dataManager!=null){
			logger.info("dataManager exists");
		}else{
			logger.info("dataManager DOES NOT EXIST");
		}
		DataElement dataElement = this.dataManager.getDataElement(id);

		if (dataElement == null) {
			throw new ResourceNotFoundException(id);
		}
		logger.info("got data element:" + deid);
		return dataElement;
	}
	


	
}
